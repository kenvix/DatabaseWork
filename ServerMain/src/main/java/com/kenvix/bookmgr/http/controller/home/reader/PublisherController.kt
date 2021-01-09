package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.utils.PublisherIDLocation
import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
object PublisherController : HomeBaseController() {
    override fun route(route: Route) {
        route {
            get<PublisherIDLocation> {

            }
        }
    }
}