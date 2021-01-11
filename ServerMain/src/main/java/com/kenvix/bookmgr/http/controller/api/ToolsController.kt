package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.toPasswordHash
import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.bookmgr.orm.tables.Setting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import io.ktor.util.date.*

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
object ToolsController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/ip") { call.respondText(call.request.origin.remoteHost) }

            get("/password") {
                val password = call.request.queryParameters.getOrFail("str")
                call.respondText(password.toPasswordHash())
            }

            get("/test") {
                respondTemplate("test") {
                    it["name"] = SettingModel.get<String>("site_name")
                }
            }

            post("/test") {
                val params = call.receiveParameters()

                call.response.cookies.append(
                    Cookie(
                        name = "test",
                        value = params["test_in"] ?: "null",
                        maxAge = (CheckUserToken.validityTimeMillsShort / 1000).toInt(),
                        expires = GMTDate(CheckUserToken.getExpiration(true).time)
                    )
                )
                call.respondText("Input: " + params["test_in"])
            }
        }
    }
}