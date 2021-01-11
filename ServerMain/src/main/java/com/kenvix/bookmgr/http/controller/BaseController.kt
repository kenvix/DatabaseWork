//--------------------------------------------------
// Class BaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.middleware.Paginate
import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.web.utils.Controller
import com.kenvix.web.utils.middlewareResultOrNull
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import java.nio.file.Path

abstract class BaseController : Controller {
    val logger = LoggerFactory.getLogger(this::class.java)!!
    open val baseTemplatePath: String
        get() = "./"

    open fun newTemplateVariableMap(pipeline: PipelineContext<*, ApplicationCall>): MutableMap<String, Any?> = HashMap()

    suspend fun PipelineContext<*, ApplicationCall>.respondTemplate(
        templateName: String,
        statusCode: HttpStatusCode = HttpStatusCode.OK,
        extraConfig: ((vars: MutableMap<String, Any?>) -> Unit)? = null
    ) = withContext(Dispatchers.IO) {
        val baseVars: MutableMap<String, Any?> = newTemplateVariableMap(this@respondTemplate)
        extraConfig?.invoke(baseVars)

        call.respond(
            statusCode,
            FreeMarkerContent("$baseTemplatePath$templateName.ftl", baseVars)
        )
    }

    suspend fun PipelineContext<*, ApplicationCall>.respondTemplate(
        templateName: String,
        extraConfig: ((vars: MutableMap<String, Any?>) -> Unit)? = null
    ) {
        respondTemplate(templateName, HttpStatusCode.OK, extraConfig)
    }
}