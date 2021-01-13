package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.middleware.Paginate
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.borrowBookForCurrentUser
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.getAllBookBorrowsForCurrentUser
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.renewBookForCurrentUser
import com.kenvix.bookmgr.http.utils.BookBorrowControllerUtils.returnBookForCurrentUser
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBook
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBooksForUser
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.http.utils.BorrowIDLocation
import com.kenvix.bookmgr.model.mysql.BookModel
import com.kenvix.bookmgr.model.mysql.BookStatusModel
import com.kenvix.web.utils.middleware
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.routing.get
import io.ktor.util.*
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
                    it["bookStatusMap"] = BookStatusModel.bookStatusMap
                    it["bookTotalCount"] = BookModel.getTableApproximateCount()
                }
            }

            route("/borrow") {
                get("/") {
                    val books = getAllBookBorrowsForCurrentUser()
                    respondTemplate("book_list") {
                        it["books"] = books
                        it["isBorrowList"] = true
                    }
                }

                // 请求借书，即“新增借书”
                post("/borrow") {
                    val id = call.receiveParameters().getOrFail("borrow_id").toLong()
                    borrowBookForCurrentUser(id)
                }

                // 续期，即“修改借书”
                post("/renew") {
                    val id = call.receiveParameters().getOrFail("borrow_id").toLong()
                    renewBookForCurrentUser(id)
                }

                // 还书，即“删除借书”
                post("/return") {
                    val id = call.receiveParameters().getOrFail("borrow_id").toLong()
                    returnBookForCurrentUser(id)
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