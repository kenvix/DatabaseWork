package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckCommonAdminToken
import com.kenvix.bookmgr.http.middleware.CheckSuperAdminToken
import com.kenvix.bookmgr.http.utils.UserControllerUtils.deleteUser
import com.kenvix.bookmgr.http.utils.UserControllerUtils.updateUserInfo
import com.kenvix.bookmgr.http.utils.UserIDLocation
import com.kenvix.bookmgr.model.mysql.BookModel
import com.kenvix.bookmgr.model.mysql.UserForAdminModel
import com.kenvix.web.utils.assertNotNull
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.respondSuccess
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.routing.post
import java.nio.file.Path

object UserController : AdminHomeBaseController() {

    @KtorExperimentalLocationsAPI
    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckSuperAdminToken)
                val users = UserForAdminModel.getAll()
                respondTemplate("user_list") {
                    it["users"] = users
                    it["userTotalCount"] = UserForAdminModel.getTableApproximateCount() - 1
                }
            }

            route("/edit") {
                get<UserIDLocation> { userId ->
                    middleware(CheckCommonAdminToken)
                    if (userId.id <= 0)
                        throw IllegalArgumentException("不能编辑系统保留用户")

                    val user = UserForAdminModel.getOneByUid(userId.id)
                    respondTemplate("../user/profile") {
                        it["isEditOtherProfile"] = true
                        it["userExtra"] = user
                    }
                }

                post<UserIDLocation> { userId ->
                    middleware(CheckCommonAdminToken)
                    if (userId.id <= 0)
                        throw IllegalArgumentException("不能编辑系统保留用户")
                    updateUserInfo(userId)
                }
            }

            post("/delete") {
                val params = call.receiveParameters()
                deleteUser(params["uid"].assertNotNull().toLong())
            }
        }
    }
}