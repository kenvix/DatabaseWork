package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBook
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.bookmgr.model.mysql.BookStatusModel
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
                }
            }

            route("/edit") {
                get<BookIDLocation> { bookId ->
                    val book = getBook(bookId.id)
                    respondTemplate("book_edit") {
                        it["book"] = book
                        it["bookStatusMap"] = BookStatusModel.bookStatusMap
                    }
                }

                post<BookIDLocation> { bookId ->

                }
            }
        }
    }
}