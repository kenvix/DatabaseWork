package com.kenvix.bookmgr.http.controller.api.admin

import io.ktor.routing.*

object SettingController : AdminApiBaseController() {
    override fun route(route: Route) {
        route {
            // 列出所有设置
            get("/") {

            }

            // 修改所有设置
            put("/") {

            }
        }
    }
}