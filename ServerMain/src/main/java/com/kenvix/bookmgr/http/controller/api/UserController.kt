package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.utils.UserControllerUtils.createUser
import com.kenvix.bookmgr.http.utils.UserControllerUtils.deleteUser
import com.kenvix.bookmgr.http.utils.UserControllerUtils.getCurrentUserInfo
import com.kenvix.bookmgr.http.utils.UserControllerUtils.getUserInfo
import com.kenvix.bookmgr.http.utils.UserControllerUtils.updateUserInfo
import com.kenvix.bookmgr.http.utils.UserIDLocation
import io.ktor.locations.*
import io.ktor.locations.put
import io.ktor.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
internal object UserController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            get("/") { getCurrentUserInfo() }
            get<UserIDLocation> { getUserInfo(it) }
            post("/") { createUser() }
            put<UserIDLocation> { updateUserInfo(it) }
            delete<UserIDLocation> { deleteUser(it.id) }
        }
    }
}
