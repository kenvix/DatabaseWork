package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.BookBorrowExpiredModel
import com.kenvix.bookmgr.model.mysql.BookBorrowModel
import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.pojos.BookBorrowForAdmin
import com.kenvix.bookmgr.orm.tables.BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN
import com.kenvix.utils.exception.BadRequestException
import com.kenvix.utils.exception.CommonBusinessException
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.respondSuccess
import com.kenvix.web.utils.toYuanMoneyString
import com.kenvix.web.utils.validateValue
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URI
import java.sql.Timestamp

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class BorrowIDLocation(val id: Long)

internal object BookBorrowControllerUtils {
    internal suspend fun PipelineContext<Unit, ApplicationCall>.getAllBookBorrowsForCurrentUser() =
        withContext(Dispatchers.IO) {
            val user = middleware(CheckUserToken)
            AppConstants.dslContext
                .select(
                    BOOK_BORROW_FOR_ADMIN.BOOK_ID,
                    BOOK_BORROW_FOR_ADMIN.BOOK_TITLE,
                    BOOK_BORROW_FOR_ADMIN.BOOK_AUTHOR_ID,
                    BOOK_BORROW_FOR_ADMIN.BOOK_AUTHOR_NAME,
                    BOOK_BORROW_FOR_ADMIN.BOOK_TYPE_ID,
                    BOOK_BORROW_FOR_ADMIN.BOOK_TYPE_NAME,
                    BOOK_BORROW_FOR_ADMIN.BOOK_PUBLISHER_ID,
                    BOOK_BORROW_FOR_ADMIN.BOOK_PUBLISHER_NAME,
                    BOOK_BORROW_FOR_ADMIN.RENEW_NUM,
                    BOOK_BORROW_FOR_ADMIN.BORROWED_AT,
                    BOOK_BORROW_FOR_ADMIN.BORROW_ID,
                    BOOK_BORROW_FOR_ADMIN.EXPECTED_RETURNED_AT,
                    BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT
                )
                .from(BOOK_BORROW_FOR_ADMIN)
                .where(BOOK_BORROW_FOR_ADMIN.BORROWER_UID.eq(user.uid))
                .orderBy(BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT.desc().nullsFirst())
                .fetchInto(BookBorrowForAdmin::class.java)
        }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.borrowBookForCurrentUser(bookId: Long): Unit = withContext(
        Dispatchers.IO
    ) {
        val user = middleware(CheckUserToken)
        if (BookBorrowExpiredModel.hasExpiredBook(user.uid))
            throw CommonBusinessException("你有超期图书，请先还清所有超期图书再借书", HttpStatusCode.NotAcceptable.value)

        val maxBorrow = SettingModel.get<Int>("book_borrow_max_borrow_num")
        val currentBorrow = BookBorrowModel.getUnreturnedBookNum(user.uid)
        if (currentBorrow >= maxBorrow)
            throw CommonBusinessException("你已经借了 $currentBorrow 本书，不能再借更多书了", HttpStatusCode.NotAcceptable.value)

        val returnAt = Timestamp(System.currentTimeMillis() + SettingModel.get<Long>("book_borrow_period_millis"))
        Routines.bookBorrow(AppConstants.jooqConfiguration, bookId, user.uid, returnAt)

        respondSuccess("借书 #${bookId} 成功，下次还书时间为 $returnAt", URI("/reader/book/borrow"))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.renewBookForCurrentUser(borrowId: Long): Unit = withContext(
        Dispatchers.IO
    ) {
        val user = middleware(CheckUserToken)
        if (BookBorrowExpiredModel.hasExpiredBook(user.uid))
            throw CommonBusinessException("你有超期图书，请先还清所有超期图书再续期", HttpStatusCode.NotAcceptable.value)

        BookBorrowModel.fetchUidById(borrowId).validateValue { user.uid == it }
        val returnAt = Routines.bookBorrowRenew(AppConstants.jooqConfiguration, borrowId)

        respondSuccess("续期成功，下次还书时间为 $returnAt", URI("/reader/book/borrow"))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.returnBookForCurrentUser(borrowId: Long): Unit = withContext(
        Dispatchers.IO
    ) {
        val user = middleware(CheckUserToken)
        val bookBorrow = BookBorrowModel.fetchOneById(borrowId)

        if (bookBorrow.borrowerUid != user.uid || bookBorrow.actualReturnedAt != null)
            throw BadRequestException("该借书不属于你或者已经还书了")

        // 超期
        val currentTime: Long = System.currentTimeMillis()
        val requiredMoney: Int = kotlin.run {
            if (bookBorrow.expectedReturnedAt.time <= currentTime) {
                val expiredDays = (currentTime - bookBorrow.expectedReturnedAt.time) / (24 * 60 * 60 * 1000)
                (expiredDays * SettingModel.get<Int>("book_expire_penalty_cents_a_day")).validateValue {
                    it < Int.MAX_VALUE
                }.toInt()
            } else {
                0
            }
        }.validateValue { it >= 0 }

        kotlin.runCatching {
            Routines.bookBorrowReturn(AppConstants.jooqConfiguration, borrowId, requiredMoney)
            respondSuccess("还书成功，扣款 ${requiredMoney.toYuanMoneyString()}", URI("/reader/book/borrow"))
        }.onFailure {
            throw CommonBusinessException(
                it.cause?.message ?: it.message + " (本次还书需要 ${requiredMoney.toYuanMoneyString()}）",
                HttpStatusCode.PaymentRequired.value
            )
        }
    }
}