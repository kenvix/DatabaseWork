package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.web.utils.middleware
import io.ktor.routing.*
import java.nio.file.Path

object BookController : HomeBaseController() {
    override val baseTemplatePath: Path
        get() = super.baseTemplatePath.resolve("admin")

    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckCommonAdminToken)
                respondTemplate("book")
            }
        }
    }
}