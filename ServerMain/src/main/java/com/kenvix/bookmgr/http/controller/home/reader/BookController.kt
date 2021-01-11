package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.middleware.Paginate
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.getAllBookBorrowsForCurrentUser
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBook
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBooksForUser
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.web.utils.middleware
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.routing.get
import java.nio.file.Path

@KtorExperimentalLocationsAPI
object BookController : HomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "reader/"

    override fun route(route: Route) {
        route {
            /**
             * 获取所有可用图书列表。
             * 筛选器可用
             * 支持使用 , 进行多作者同时筛选
             */
            get("/") {
                val books = getBooksForUser()
                respondTemplate("book_list") {
                    it["books"] = books
                }
            }

            get("/borrow") {
                val books = getAllBookBorrowsForCurrentUser()
                respondTemplate("book_borrow_list") {
                    it["books"] = books
                }
            }

            get("/search") {
                middleware(CheckUserToken)
                respondTemplate("book_search")
            }

            get<BookIDLocation> { bookId ->
                val book = getBook(bookId.id)
                respondTemplate("book_detail") {
                    it["book"] = book
                }
            }
        }
    }
}