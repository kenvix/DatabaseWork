package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.controller.home.reader.BookController.respondTemplate
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBook
import com.kenvix.bookmgr.http.utils.AdminBookControllerUtils.addBook
import com.kenvix.bookmgr.http.utils.AdminBookControllerUtils.updateBook
import com.kenvix.bookmgr.http.utils.AdminBookControllerUtils.deleteBook
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBookAdmin
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBooksForAdmin
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBooksForUser
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.BookModel
import com.kenvix.bookmgr.model.mysql.BookStatusModel
import com.kenvix.bookmgr.model.mysql.BookTypeModel
import com.kenvix.bookmgr.model.mysql.PublisherModel
import com.kenvix.web.utils.assertNotNull
import com.kenvix.web.utils.middleware
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.routing.get

object BookController : AdminHomeBaseController() {
    @KtorExperimentalLocationsAPI
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckCommonAdminToken)

                val books = getBooksForAdmin()
                respondTemplate("book_list") {
                    it["books"] = books
                    it["bookStatusMap"] = BookStatusModel.bookStatusMap
                    it["bookTotalCount"] = BookModel.getTableApproximateCount()
                }
            }

            get("/search") {
                middleware(CheckCommonAdminToken)
                respondTemplate("../reader/book_search") {
                    it["isAdminSearch"] = true
                }
            }

            get("/add") {
                middleware(CheckCommonAdminToken)
                respondTemplate("book_edit") {
                    it["bookStatusMap"] = BookStatusModel.bookStatusMap
                    it["publisherMap"] = PublisherModel.publisherMap
                    it["bookTypeMap"] = BookTypeModel.bookStatusMap
                }
            }

            post("/add") {
                middleware(CheckCommonAdminToken)
                addBook()
            }

            route("/edit") {
                get<BookIDLocation> { bookId ->
                    middleware(CheckCommonAdminToken)
                    val book = getBookAdmin(bookId.id)

                    respondTemplate("book_edit") {
                        it["book"] = book.book
                        it["book_created_at"] = book.book.createdAt.toString().replace(" ", "T")
                        it["authors"] = book.authors
                        it["bookStatusMap"] = BookStatusModel.bookStatusMap
                        it["publisherMap"] = PublisherModel.publisherMap
                        it["bookTypeMap"] = BookTypeModel.bookStatusMap
                    }
                }

                post<BookIDLocation> { bookId ->
                    middleware(CheckCommonAdminToken)
                    updateBook(bookId.id)
                }
            }

            post("/delete") {
                middleware(CheckCommonAdminToken)
                val params: Parameters = call.receiveParameters()
                deleteBook(params["book_id"].assertNotNull().toLong())
            }
        }
    }
}