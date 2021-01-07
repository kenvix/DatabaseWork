package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.BookForUserAndAuthors
import com.kenvix.bookmgr.http.controller.api.admin.ApiBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.AuthorModel
import com.kenvix.bookmgr.model.mysql.BookForUserModel.getBooksForUser
import com.kenvix.bookmgr.orm.tables.BookAuthor.BOOK_AUTHOR
import com.kenvix.bookmgr.orm.tables.BookAuthorMap.BOOK_AUTHOR_MAP
import com.kenvix.bookmgr.orm.tables.BookForUser.BOOK_FOR_USER
import com.kenvix.bookmgr.orm.tables.pojos.BookAuthor
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
object BookController : ApiBaseController() {

    override fun route(route: Route) {
        route {
            /**
             * 获取所有可用图书列表。
             * 筛选器可用
             * 支持使用 , 进行多作者同时筛选
             */
            get("/") {
                middleware(CheckUserToken)

                val params = call.request.queryParameters
                val conditions = sequenceOf(
                    params["filter_title"].ifNotNull { BOOK_FOR_USER.TITLE.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
                    params["filter_publisher"].ifNotNull { BOOK_FOR_USER.PUBLISHER_NAME.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
                    params["filter_description"].ifNotNull { BOOK_FOR_USER.DESCRIPTION.likeIgnoreCase("%" + it.strictSqlSafe() + "%") },
                    params["filter_available"].ifNotNull { BOOK_FOR_USER.NUM_AVAILABLE.greaterThan(0) },
                    params["filter_type"].ifNotNull { BOOK_FOR_USER.TYPE_NAME.eq(it.strictSqlSafe()) },
                    params["filter_author"].ifNotNull {
                        val authors = AuthorModel.getAuthorsIdsConditionByName(it.split(','))
                        BOOK_AUTHOR_MAP.AUTHOR_ID.`in`(authors)
                    }
                ).filterNotNull().toList()

                respondJson(getBooksForUser(conditions))
            }

            /**
             * 获取某图书详细信息
             */
            get<BookIDLocation> {
                middleware(CheckUserToken)
                val book = getBooksForUser(listOf(BOOK_FOR_USER.ID.equal(it.id))).assertNotEmpty()
                val authors = AppConstants.dslContext.select().from(BOOK_AUTHOR)
                    .where(BOOK_AUTHOR.BOOK_ID.eq(it.id)).fetchInto(BookAuthor::class.java)

                respondJson(BookForUserAndAuthors(book[0], authors))
            }
        }
    }
}