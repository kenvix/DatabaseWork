package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.PublisherIDLocation
import com.kenvix.web.utils.middleware
import io.ktor.locations.*
import io.ktor.routing.*
import java.nio.file.Path

@KtorExperimentalLocationsAPI
object PublisherController : HomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "reader/"

    override fun route(route: Route) {
        route {
            get<PublisherIDLocation> { publisherId ->
                middleware(CheckUserToken)
                respondTemplate("publisher_detail") {
                    it["publisher_id"] = publisherId.id
                }
            }
        }
    }
}