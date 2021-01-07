//--------------------------------------------------
// Class ApiRoutes
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

@file:Suppress("unused")

package com.kenvix.bookmgr.http.routes

import com.kenvix.bookmgr.http.controller.TODOController
import com.kenvix.bookmgr.http.controller.api.*
import com.kenvix.bookmgr.http.controller.api.reader.AuthorController
import com.kenvix.bookmgr.http.controller.api.reader.BookBorrowController
import com.kenvix.bookmgr.http.controller.api.reader.BookController
import com.kenvix.bookmgr.http.controller.api.reader.PublisherController
import com.kenvix.utils.preferences.ServerEnv
import com.kenvix.web.server.KtorModule
import com.kenvix.web.utils.controller
import io.ktor.application.Application
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.routing.route
import io.ktor.routing.routing

@OptIn(KtorExperimentalLocationsAPI::class)
class ApiRoutes : KtorModule {

    override fun module(application: Application, testing: Boolean) {
        application.routing {
            /**
             * API Base url is
             * /api/v1
             */
            route(ServerEnv.ApiBaseUrl) {
                controller("/user", UserController)
                controller("/session", SessionController)
                controller("/tools", ToolsController)

                route("/reader") {
                    controller("/book", BookController)
                    controller("/book/borrow", BookBorrowController)
                    controller("/publisher", PublisherController)
                    controller("/author", AuthorController)
                }

                route("/admin") {
                    controller("/user", TODOController)
                    controller("/book", TODOController)
                    controller("/book/borrow", TODOController)
                }
            }
        }
    }
}