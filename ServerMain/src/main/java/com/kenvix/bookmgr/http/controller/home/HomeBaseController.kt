//--------------------------------------------------
// Class HomeBaseController
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.http.controller.home

import com.kenvix.bookmgr.http.controller.BaseController
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.middleware.Paginate
import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.web.utils.middlewareResultOrNull
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.util.pipeline.*
import org.apache.commons.text.StringEscapeUtils
import java.nio.file.Path

abstract class HomeBaseController : BaseController() {
    override val baseTemplatePath: String
        get() = super.baseTemplatePath + "home/"

    override fun newTemplateVariableMap(pipeline: PipelineContext<*, ApplicationCall>): MutableMap<String, Any?> {
        return super.newTemplateVariableMap(pipeline).apply {
            put("user", pipeline.middlewareResultOrNull(CheckUserToken))
            put("page", pipeline.middlewareResultOrNull(Paginate)?.currentPage ?: 0)
            put("siteName", SettingModel.get<String>("site_name"))
            put("msg", pipeline.call.request.queryParameters["msg"]?.run { StringEscapeUtils.escapeHtml4(this) })
        }
    }
}