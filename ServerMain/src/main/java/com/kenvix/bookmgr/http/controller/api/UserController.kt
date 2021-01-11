package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.utils.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.util.*

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
internal object UserController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") { getCurrentUserInfo() }
            get<UserIDLocation> { getUserInfo(it) }
            post("/") { createUser() }
            put<UserIDLocation> { updateUserInfo(it) }
            delete<UserIDLocation> { deleteUser(it) }
        }
    }
}
