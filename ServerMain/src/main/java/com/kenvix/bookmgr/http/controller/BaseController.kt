//--------------------------------------------------
// Class BaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.middleware.Paginate
import com.kenvix.web.utils.Controller
import com.kenvix.web.utils.middlewareResultOrNull
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.nio.file.Path
import java.util.function.Consumer

abstract class BaseController : Controller {
    val logger = LoggerFactory.getLogger(this::class.java)!!
    open val baseTemplatePath: Path
        get() = Path.of(".")

    suspend fun PipelineContext<*, ApplicationCall>.respondTemplate(
        templateName: String,
        extraConfig: ((vars: MutableMap<String, Any?>) -> Unit)? = null,
        statusCode: HttpStatusCode = HttpStatusCode.OK
    ) {
        val baseVars: MutableMap<String, Any?> = mutableMapOf(
            "user" to middlewareResultOrNull(CheckUserToken),
            "page" to (middlewareResultOrNull(Paginate)?.currentPage ?: 0)
        )
        extraConfig?.invoke(baseVars)

        call.respond(
            statusCode,
            FreeMarkerContent(baseTemplatePath.resolve("$templateName.ftl").toString(), baseVars)
        )
    }

    suspend fun PipelineContext<*, ApplicationCall>.respondTemplate(
        templateName: String,
        statusCode: HttpStatusCode = HttpStatusCode.OK
    ) {
        respondTemplate(templateName, null, statusCode)
    }
}