package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.AuthorModel
import com.kenvix.bookmgr.model.mysql.BookForUserModel
import com.kenvix.bookmgr.orm.Tables.BOOK_FOR_USER
import com.kenvix.bookmgr.orm.tables.BookAuthorMap
import com.kenvix.bookmgr.orm.tables.BookForUser
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthor
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class BookIDLocation(val id: Long)

internal object BookControllerUtils {
    /**
     * 获取所有可用图书列表。
     * 筛选器可用
     * 支持使用 , 进行多作者同时筛选
     */
    internal suspend fun PipelineContext<Unit, ApplicationCall>.getBooksForUser() = withContext(Dispatchers.IO) {
        middleware(CheckUserToken)

        val params = call.request.queryParameters
        BookForUserModel.getBooksForUser(buildFilter(params))
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.getBooksForAdmin() = withContext(Dispatchers.IO) {
        middleware(CheckUserToken)

        val params = call.request.queryParameters
        BookForUserModel.getBooksForAdmin(buildFilter(params))
    }

    private fun PipelineContext<Unit, ApplicationCall>.buildFilter(params: Parameters) = sequenceOf(
            params["filter_title"].ifNotNullOrBlank { BookForUser.BOOK_FOR_USER.TITLE.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
            params["filter_publisher"].ifNotNullOrBlank { BookForUser.BOOK_FOR_USER.PUBLISHER_NAME.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
            params["filter_description"].ifNotNullOrBlank { BookForUser.BOOK_FOR_USER.DESCRIPTION.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
            params["filter_available"].ifNotNullOrBlank { BookForUser.BOOK_FOR_USER.NUM_AVAILABLE.greaterThan(0) },
            params["filter_type"].ifNotNullOrBlank { BookForUser.BOOK_FOR_USER.TYPE_NAME.eq(it.strictSqlSafe()) },
            params["filter_author"].ifNotNullOrBlank {
                val authors = AuthorModel.getAuthorsIdsConditionByName(it.split(','))
                BOOK_FOR_USER.AUTHOR_ID.`in`(authors)
            }
        ).filterNotNull().toList()

    /**
     * 获取某图书详细信息
     */
    internal suspend fun PipelineContext<Unit, ApplicationCall>.getBook(bookId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckUserToken)
        val book = BookForUserModel.getBooksForUser(listOf(BookForUser.BOOK_FOR_USER.ID.equal(bookId))).assertNotEmpty()
        val authors = AppConstants.dslContext.select().from(com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR)
            .where(com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR.BOOK_ID.eq(bookId)).fetchInto(BookAuthor::class.java)

        BookForUserAndAuthors(book[0], authors)
    }

    internal suspend fun PipelineContext<Unit, ApplicationCall>.getBookAdmin(bookId: Long) = withContext(Dispatchers.IO) {
        middleware(CheckCommonAdminToken)
        val book = BookForUserModel.getBooksForAdmin(listOf(BookForUser.BOOK_FOR_USER.ID.equal(bookId))).assertNotEmpty()
        val authors = AppConstants.dslContext.select().from(com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR)
            .where(com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR.BOOK_ID.eq(bookId)).fetchInto(BookAuthor::class.java)

        BookForUserAndAuthors(book[0], authors)
    }
}