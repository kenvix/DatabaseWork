package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.utils.*
import com.kenvix.bookmgr.http.utils.SessionControllerUtils.createSession
import com.kenvix.bookmgr.http.utils.SessionControllerUtils.deleteSession
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.util.*

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
object SessionController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            post("/") { createSession() }
            delete("/") { deleteSession() }
        }
    }
}