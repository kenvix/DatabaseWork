package com.kenvix.bookmgr.http.controller.api.reader

import com.kenvix.bookmgr.http.controller.api.ApiBaseController
import io.ktor.routing.*

object BookBorrowController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            // 列出我的所有借书
            get("/") {
            }
        }
    }
}