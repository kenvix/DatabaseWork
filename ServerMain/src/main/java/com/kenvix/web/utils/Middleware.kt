//--------------------------------------------------
// Interface Middleware
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.web.utils

import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext

interface BaseMiddleware<T>

interface Middleware<T> : BaseMiddleware<T> {
    fun handle(pipeline: PipelineContext<*, ApplicationCall>): T
}

interface MiddlewareSuspend<T> : BaseMiddleware<T> {
    suspend fun handle(pipeline: PipelineContext<*, ApplicationCall>): T
}