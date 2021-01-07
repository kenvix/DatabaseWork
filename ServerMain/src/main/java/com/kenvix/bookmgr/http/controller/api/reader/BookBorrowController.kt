package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.BookBorrowForAdmin
import com.kenvix.bookmgr.orm.tables.BookBorrowForAdmin.BOOK_BORROW_FOR_ADMIN
import com.kenvix.bookmgr.orm.tables.daos.BookBorrowDao
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.respondJson
import com.kenvix.web.utils.respondSuccess
import io.ktor.locations.*
import io.ktor.routing.*
import java.sql.Timestamp

@OptIn(KtorExperimentalLocationsAPI::class)
object BookBorrowController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            // 列出我的所有借书
            get("/") {
                val user = middleware(CheckUserToken)
                val books = AppConstants.dslContext
                    .select(BOOK_BORROW_FOR_ADMIN.BOOK_ID, BOOK_BORROW_FOR_ADMIN.BOOK_TITLE, BOOK_BORROW_FOR_ADMIN.BORROWED_AT, BOOK_BORROW_FOR_ADMIN.EXPECTED_RETURNED_AT, BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT)
                    .from(BOOK_BORROW_FOR_ADMIN)
                    .where(BOOK_BORROW_FOR_ADMIN.BORROWER_UID.eq(user.uid))
                    .orderBy(BOOK_BORROW_FOR_ADMIN.ACTUAL_RETURNED_AT.desc().nullsFirst())
                    .fetchInto(BookBorrowForAdmin::class.java)

                respondJson(books)
            }

            // 请求借书，即“新增借书”
            post<BookIDLocation> {
                val user = middleware(CheckUserToken)
                val returnAt = Timestamp(System.currentTimeMillis() + SettingModel.get<Long>("book_borrow_period_millis"))
                Routines.bookBorrow(AppConstants.jooqConfiguration, user.uid, it.id, returnAt)

                respondSuccess("借书成功，下次还书时间为 $returnAt")
            }

            // 还书，即“删除借书”
            delete<BookIDLocation> {
                val user = middleware(CheckUserToken)

            }

            // 续期，即“修改借书”
            patch<BookIDLocation> {
                val user = middleware(CheckUserToken)
                val book = BookBorrowDao(AppConstants.jooqConfiguration).fetchOneById(user.uid)

            }
        }
    }
}