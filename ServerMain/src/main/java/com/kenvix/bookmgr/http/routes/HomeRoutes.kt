//--------------------------------------------------
// Class ApiRoutes
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

@file:Suppress("unused")

package com.kenvix.bookmgr.http.routes

import com.kenvix.bookmgr.http.controller.home.IndexController
import com.kenvix.bookmgr.http.controller.home.UserController
import com.kenvix.bookmgr.http.controller.home.reader.AuthorController
import com.kenvix.bookmgr.http.controller.home.reader.BookController
import com.kenvix.bookmgr.http.controller.home.reader.PublisherController
import com.kenvix.web.server.KtorModule
import com.kenvix.web.utils.controller
import io.ktor.application.Application
import io.ktor.locations.*
import io.ktor.routing.route
import io.ktor.routing.routing

class HomeRoutes : KtorModule {
    @KtorExperimentalLocationsAPI
    override fun module(application: Application, testing: Boolean) {
        application.routing {
            controller("/", IndexController)
            controller("/user", UserController)

            route("/reader") {
                controller("/reader", BookController)
                controller("/author", AuthorController)
                controller("/publisher", PublisherController)
            }

            route("/admin") {
                controller("/user", com.kenvix.bookmgr.http.controller.home.admin.UserController)
                controller("/book", com.kenvix.bookmgr.http.controller.home.admin.BookController)
                controller("/setting", com.kenvix.bookmgr.http.controller.home.admin.SettingController)
            }
        }
    }
}