package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.AuthorControllerUtils.getAuthor
import com.kenvix.bookmgr.http.utils.AuthorIDLocation
import com.kenvix.web.utils.middleware
import io.ktor.locations.*
import io.ktor.routing.*
import java.nio.file.Path

@KtorExperimentalLocationsAPI
object AuthorController : HomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "reader/"

    override fun route(route: Route) {
        route {
            get<AuthorIDLocation> { authorId ->
                val author = getAuthor(authorId.id)
                respondTemplate("author_detail") {
                    it["author"] = author
                }
            }
        }
    }
}