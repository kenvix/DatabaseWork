package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.web.utils.middleware
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.routing.get
import java.nio.file.Path

@KtorExperimentalLocationsAPI
object BookController : HomeBaseController() {
    override val baseTemplatePath: Path
        get() = super.baseTemplatePath.resolve("reader")

    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckUserToken)
                respondTemplate("book_list")
            }

            get("/borrow") {
                middleware(CheckUserToken)
                respondTemplate("book_borrow_list")
            }

            get("/search") {
                middleware(CheckUserToken)
                respondTemplate("book_search")
            }

            get<BookIDLocation> { bookId ->
                middleware(CheckUserToken)
                respondTemplate("book_detail") {
                    it["book_id"] = bookId.id
                }
            }
        }
    }
}