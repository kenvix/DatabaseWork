package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckSuperAdminToken
import com.kenvix.web.utils.middleware
import io.ktor.routing.*

object SettingController : AdminHomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "admin/"

    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckSuperAdminToken)
                respondTemplate("setting")
            }
        }
    }
}