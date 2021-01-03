package com.kenvix.bookmgr.http.controller.home

import io.ktor.routing.Route
import io.ktor.routing.get

object IndexController : HomeBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                TODO("HTML index page todo :(   Is there anyone can implement me?")
            }
        }
    }
}