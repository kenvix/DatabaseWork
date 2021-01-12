package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.AuthorModel
import com.kenvix.bookmgr.model.mysql.BookForUserModel
import com.kenvix.bookmgr.orm.tables.BookAuthorMap
import com.kenvix.bookmgr.orm.tables.BookForUser
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthor
import com.kenvix.web.utils.assertNotEmpty
import com.kenvix.web.utils.ifNotNull
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.strictSqlSafe
import io.ktor.application.*
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
        val conditions = sequenceOf(
            params["filter_title"].ifNotNull { BookForUser.BOOK_FOR_USER.TITLE.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
            params["filter_publisher"].ifNotNull { BookForUser.BOOK_FOR_USER.PUBLISHER_NAME.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
            params["filter_description"].ifNotNull { BookForUser.BOOK_FOR_USER.DESCRIPTION.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
            params["filter_available"].ifNotNull { BookForUser.BOOK_FOR_USER.NUM_AVAILABLE.greaterThan(0) },
            params["filter_type"].ifNotNull { BookForUser.BOOK_FOR_USER.TYPE_NAME.eq(it.strictSqlSafe()) },
            params["filter_author"].ifNotNull {
                val authors = AuthorModel.getAuthorsIdsConditionByName(it.split(','))
                BookAuthorMap.BOOK_AUTHOR_MAP.AUTHOR_ID.`in`(authors)
            }
        ).filterNotNull().toList()

        BookForUserModel.getBooksForUser(conditions)
    }

    /**
     * 获取某图书详细信息
     */
    internal suspend fun PipelineContext<Unit, ApplicationCall>.getBook(bookId: Long, fetchAllInfo: Boolean = false) = withContext(Dispatchers.IO) {
        middleware(CheckUserToken)
        val book = BookForUserModel.getBooksForUser(listOf(BookForUser.BOOK_FOR_USER.ID.equal(bookId)), fetchAllInfo).assertNotEmpty()
        val authors = AppConstants.dslContext.select().from(com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR)
            .where(com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR.BOOK_ID.eq(bookId)).fetchInto(BookAuthor::class.java)

        BookForUserAndAuthors(book[0], authors)
    }
}