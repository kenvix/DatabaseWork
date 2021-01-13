//--------------------------------------------------
// Class ApiRoutes
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

@file:Suppress("unused")

package com.kenvix.bookmgr.http.routes

import com.kenvix.bookmgr.http.controller.home.IndexController
import com.kenvix.bookmgr.http.controller.home.UserController
import com.kenvix.bookmgr.http.controller.home.reader.AuthorController as ReaderAuthorController
import com.kenvix.bookmgr.http.controller.home.reader.BookController as ReaderBookController
import com.kenvix.bookmgr.http.controller.home.reader.PublisherController as ReaderPublisherController
import com.kenvix.web.server.KtorModule
import com.kenvix.web.utils.controller
import io.ktor.application.Application
import io.ktor.locations.*
import io.ktor.routing.route
import io.ktor.routing.routing
import com.kenvix.bookmgr.http.controller.home.admin.UserController as AdminUserController
import com.kenvix.bookmgr.http.controller.home.admin.BookController as AdminBookController
import com.kenvix.bookmgr.http.controller.home.admin.SettingController as AdminSettingController

class HomeRoutes : KtorModule {
    @KtorExperimentalLocationsAPI
    override fun module(application: Application, testing: Boolean) {
        application.routing {
            controller("/", IndexController)
            controller("/user", UserController)

            route("/reader") {
                controller("/book", ReaderBookController)
                controller("/author", ReaderAuthorController)
                controller("/publisher", ReaderPublisherController)
            }

            route("/admin") {
                controller("/user", AdminUserController)
                controller("/book", AdminBookController)
                controller("/setting", AdminSettingController)
            }
        }
    }
}