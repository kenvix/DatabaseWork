package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.web.utils.middleware
import io.ktor.routing.*
import java.nio.file.Path
import com.kenvix.web.utils.plus

object UserController : HomeBaseController() {
    override val baseTemplatePath: Path
        get() = super.baseTemplatePath + "user"

    override fun route(route: Route) {
        route {
            get("/login") {
                respondTemplate("login")
            }

            get("/register") {
                respondTemplate("register")
            }

            get("/password/reset") {
                respondTemplate("password_reset")
            }

            get("/profile") {
                middleware(CheckUserToken)
                respondTemplate("profile")
            }

            get("/personalize") {
                middleware(CheckUserToken)
                respondTemplate("personalize")
            }
        }
    }
}