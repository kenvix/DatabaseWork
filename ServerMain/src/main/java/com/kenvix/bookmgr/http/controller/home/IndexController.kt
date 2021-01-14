package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.*
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.toYuanMoneyString
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.util.*
import java.time.Instant

object IndexController : HomeBaseController() {
    override fun route(route: Route) {
        route {
            get("/") {
                val user= middleware(CheckUserToken)
                val extra = UserForAdminModel.getOneByUid(user.uid)
                respondTemplate("index") {
                    it["userExtra"] = extra
                    it["moneyInYuan"] = extra!!.money.toYuanMoneyString()
                    it["bookTotalCount"] = BookModel.getTableApproximateCount()
                    it["userTotalCount"] = UserModel.getTableApproximateCount()
                    it["bookBorrowTotalCount"] = BookBorrowModel.getTableApproximateCount()
                }
            }
        }
    }
}