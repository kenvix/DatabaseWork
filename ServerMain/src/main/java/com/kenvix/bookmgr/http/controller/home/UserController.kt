package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.*
import com.kenvix.bookmgr.http.utils.SessionControllerUtils.createSession
import com.kenvix.bookmgr.http.utils.SessionControllerUtils.deleteSession
import com.kenvix.bookmgr.http.utils.*
import com.kenvix.bookmgr.http.utils.UserControllerUtils.createUser
import com.kenvix.bookmgr.http.utils.UserControllerUtils.updateUserInfo
import com.kenvix.web.utils.middleware
import io.ktor.routing.*
import java.nio.file.Path
import com.kenvix.web.utils.plus
import io.ktor.application.*
import io.ktor.response.*

object UserController : HomeBaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "user/"

    override fun route(route: Route) {
        route {
            get("/login") {
                respondTemplate("login")
            }

            get("/login/action"){
                call.respondText("ASSDFSD ")
            }

            post("/asshole") {
                call.respondText("asdwerrerererereffre ")
            }

            post("/login/action") {
                createSession()
            }

            post("/logout/action") {
                deleteSession()
            }

            get("/register") {
                respondTemplate("register")
            }

            post("/register/action") {
                createUser()
            }

            get("/password/reset") {
                respondTemplate("password_reset")
            }

            post("/password/reset/action") {

            }

            get("/profile") {
                middleware(CheckUserToken)
                respondTemplate("profile")
            }

            post("/profile/action") {
                updateUserInfo()
            }

            get("/personalize") {
                middleware(CheckUserToken)
                respondTemplate("personalize")
            }
        }
    }
}