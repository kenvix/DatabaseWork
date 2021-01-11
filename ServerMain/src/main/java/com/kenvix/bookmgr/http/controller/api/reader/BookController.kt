package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBook
import com.kenvix.bookmgr.http.utils.BookControllerUtils.getBooksForUser
import com.kenvix.bookmgr.http.utils.BookIDLocation
import com.kenvix.web.utils.respondJson
import io.ktor.locations.*
import io.ktor.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
object BookController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                respondJson(getBooksForUser())
            }

            get<BookIDLocation> {
                respondJson(getBook(it.id))
            }
        }
    }
}