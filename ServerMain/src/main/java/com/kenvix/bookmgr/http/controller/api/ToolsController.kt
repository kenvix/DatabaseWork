package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.utils.toPasswordHash
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
object ToolsController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/ip") { call.respondText(call.request.origin.remoteHost) }
            get("/password") {
                val password = call.request.queryParameters.getOrFail("str")
                call.respondText(password.toPasswordHash())
            }
        }
    }
}