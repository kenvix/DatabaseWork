//--------------------------------------------------
// Class ApiRoutes
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

@file:Suppress("unused")

package com.kenvix.bookmgr.http.routes

import com.kenvix.bookmgr.http.controller.home.IndexController
import com.kenvix.web.server.KtorModule
import io.ktor.application.Application
import io.ktor.routing.route
import io.ktor.routing.routing

class HomeRoutes : KtorModule {
    override fun module(application: Application, testing: Boolean) {
        application.routing {
            route("/", IndexController::route)
        }
    }
}