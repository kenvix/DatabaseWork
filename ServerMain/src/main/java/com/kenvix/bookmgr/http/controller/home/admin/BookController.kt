package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBook
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.BookStatusModel
import com.kenvix.bookmgr.model.mysql.BookTypeModel
import com.kenvix.bookmgr.model.mysql.PublisherModel
import com.kenvix.web.utils.middleware
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.routing.get

object BookController : AdminHomeBaseController() {
    @KtorExperimentalLocationsAPI
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckCommonAdminToken)
                respondTemplate("book")
            }

            get("/add") {
                middleware(CheckCommonAdminToken)
                respondTemplate("book_edit") {
                    it["bookStatusMap"] = BookStatusModel.bookStatusMap
                    it["publisherMap"] = PublisherModel.publisherMap
                    it["bookTypeMap"] = BookTypeModel.bookStatusMap
                }
            }

            route("/edit") {
                get<BookIDLocation> { bookId ->
                    val book = getBook(bookId.id, true)
                    respondTemplate("book_edit") {
                        it["book"] = book.book
                        it["authors"] = book.authors
                        it["bookStatusMap"] = BookStatusModel.bookStatusMap
                        it["publisherMap"] = PublisherModel.publisherMap
                        it["bookTypeMap"] = BookTypeModel.bookStatusMap
                    }
                }

                post<BookIDLocation> { bookId ->

                }
            }
        }
    }
}