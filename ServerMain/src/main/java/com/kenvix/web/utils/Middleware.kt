//--------------------------------------------------
// Interface Middleware
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.web.utils

import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext

interface Middleware<T> {
    fun handle(pipeline: PipelineContext<*, ApplicationCall>): T
}

interface MiddlewareSuspend<T> {
    suspend fun handle(pipeline: PipelineContext<*, ApplicationCall>): T
}