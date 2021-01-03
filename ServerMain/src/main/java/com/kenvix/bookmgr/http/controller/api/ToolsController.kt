package com.kenvix.bookmgr.http.controller.api

import io.ktor.application.call
import io.ktor.features.origin
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.util.KtorExperimentalAPI

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
object ToolsController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/ip") { call.respondText(call.request.origin.remoteHost) }
        }
    }

}