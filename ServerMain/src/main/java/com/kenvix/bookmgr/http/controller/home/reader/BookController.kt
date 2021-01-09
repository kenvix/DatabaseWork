package com.kenvix.bookmgr.http.controller.home.reader

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import io.ktor.routing.*

object BookController : HomeBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                respondTemplate("")
            }

            get("/borrow") {

            }

            get("/search") {

            }
        }
    }
}