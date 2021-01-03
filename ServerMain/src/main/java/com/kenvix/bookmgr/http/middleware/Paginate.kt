package com.kenvix.bookmgr.http.middleware

import com.kenvix.web.utils.Middleware
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.util.pipeline.PipelineContext

object Paginate : Middleware<Int> {
    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): Int {
        return try {
            pipeline.call.request.queryParameters["page"]?.toInt() ?: 0
        } catch (exception: Exception) {
            0
        }
    }
}