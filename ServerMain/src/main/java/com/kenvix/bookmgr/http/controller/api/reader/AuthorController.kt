package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import com.kenvix.bookmgr.http.utils.AuthorControllerUtils.addAuthor
import com.kenvix.bookmgr.http.utils.AuthorControllerUtils.deleteAuthor
import com.kenvix.bookmgr.http.utils.AuthorControllerUtils.getAllAuthors
import com.kenvix.bookmgr.http.utils.AuthorControllerUtils.getAuthor
import com.kenvix.bookmgr.http.utils.AuthorControllerUtils.updateAuthor
import com.kenvix.bookmgr.http.utils.AuthorIDLocation
import com.kenvix.web.utils.respondJson
import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
object AuthorController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                respondJson(getAllAuthors())
            }

            get<AuthorIDLocation> { authorId ->
                respondJson(getAuthor(authorId.id))
            }

            post("/") {
                addAuthor()
            }

            put<AuthorIDLocation> { authorId ->
                updateAuthor(authorId.id)
            }

            delete<AuthorIDLocation> { authorId ->
                deleteAuthor(authorId.id)
            }
        }
    }
}