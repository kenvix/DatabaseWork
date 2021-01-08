//--------------------------------------------------
// Class HomeBaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.controller.BaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.web.utils.middlewareResultOrNull
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*

abstract class HomeBaseController : BaseController() {
    suspend fun PipelineContext<*, ApplicationCall>.respondTemplate(templateName: String) {
        call.respond(HttpStatusCode.OK, FreeMarkerContent("home/$templateName.ftl", mapOf(
            "user" to middlewareResultOrNull(CheckUserToken)
        )))
    }
}