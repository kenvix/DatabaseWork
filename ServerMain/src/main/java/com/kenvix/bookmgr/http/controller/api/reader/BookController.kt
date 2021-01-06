package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import io.ktor.routing.*

object BookController : ApiBaseController() {

    override fun route(route: Route) {
        route {
            // 获取所有可用图书
            get("/") {

            }
        }
    }
}