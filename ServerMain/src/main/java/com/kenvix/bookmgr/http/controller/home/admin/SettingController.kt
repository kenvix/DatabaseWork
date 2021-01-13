package com.kenvix.bookmgr.http.controller.home.admin

import com.kenvix.bookmgr.http.controller.home.HomeBaseController
import com.kenvix.bookmgr.http.middleware.CheckSuperAdminToken
import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.utils.exception.BadRequestException
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.respondSuccess
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*
import java.net.URI

object SettingController : AdminHomeBaseController() {

    override fun route(route: Route) {
        route {
            get("/") {
                middleware(CheckSuperAdminToken)
                val settings  = SettingModel.getAll()
                respondTemplate("system_setting") {
                    it["settings"] = settings
                }
            }

            post("/") {
                middleware(CheckSuperAdminToken)
                val params = call.receiveParameters()
                val settings  = SettingModel.getAll()

                SettingModel.transactionThreadLocal {
                    settings.forEach { option ->
                        val newOptionValue = params[option.key] ?: ""
                        when (option.type) {
                            "Int" -> newOptionValue.toInt()
                            "Double" -> newOptionValue.toDouble()
                            "Float" -> newOptionValue.toFloat()
                            "Long" -> newOptionValue.toLong()
                            "Short" -> newOptionValue.toShort()
                            "Bool" -> { if (newOptionValue != "true" && newOptionValue != "false") throw BadRequestException("你输入的设置有错误") }
                            "Boolean" -> { if (newOptionValue != "true" && newOptionValue != "false") throw BadRequestException("你输入的设置有错误") }
                        }
                        option.value = newOptionValue
                        SettingModel.update(option)
                    }
                }

                respondSuccess("修改设置成功", URI("/admin/setting"))
            }
        }
    }
}