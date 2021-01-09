package com.kenvix.bookmgr.http.middleware

import com.kenvix.bookmgr.model.mysql.SettingModel
import com.kenvix.web.utils.Middleware
import com.kenvix.web.utils.middlewareResultOrNull
import io.ktor.application.*
import io.ktor.util.pipeline.*
import kotlin.math.*

object Paginate : Middleware<PaginationInfo>() {
    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): PaginationInfo {
        return PaginationInfo(currentPage = max(0, try {
            pipeline.call.request.queryParameters["page"]?.toInt() ?: 0
        } catch (exception: Exception) {
            0
        }), numPerPage = min(
            SettingModel["max_user_pagination_num"],
            pipeline.call.request.cookies["paginate"]?.toInt() ?: SettingModel["default_user_pagination_num"],
        ))
    }
}

data class PaginationInfo(val currentPage: Int, val numPerPage: Int)

val PipelineContext<*, ApplicationCall>.paginationInfo
    get() = middlewareResultOrNull(Paginate)