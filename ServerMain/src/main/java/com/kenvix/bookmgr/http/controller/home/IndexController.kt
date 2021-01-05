package com.kenvix.bookmgr.http.controller.home

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.Route
import io.ktor.routing.get
import java.time.Instant

object IndexController : HomeBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                TODO("HTML index page todo :(   Is there anyone can implement me?")
            }

            get("/asshole") {
                call.respondText("ASSHOLE ${Instant.now()}")
            }
        }
    }
}