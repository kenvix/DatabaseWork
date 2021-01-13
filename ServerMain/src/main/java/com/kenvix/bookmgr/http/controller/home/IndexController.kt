package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.web.utils.middleware
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.util.*
import java.time.Instant

object IndexController : HomeBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckUserToken)
                respondTemplate("index")
            }
        }
    }
}