package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.createSession
import com.kenvix.bookmgr.http.utils.deleteSession
import com.kenvix.web.utils.middleware
import io.ktor.routing.*
import java.nio.file.Path
import com.kenvix.web.utils.plus

object UserController : HomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "user/"

    override fun route(route: Route) {
        route {
            get("/login") {
                respondTemplate("login")
            }

            post("/login/action") {
                createSession()
            }

            get("/register") {
                respondTemplate("register")
            }

            post("/register/action") {
                deleteSession()
            }

            get("/password/reset") {
                respondTemplate("password_reset")
            }

            post("/password/action") {

            }

            get("/profile") {
                middleware(CheckUserToken)
                respondTemplate("profile")
            }

            post("/profile/action") {

            }

            get("/personalize") {
                middleware(CheckUserToken)
                respondTemplate("personalize")
            }

            post("/personalize/action") {

            }
        }
    }
}