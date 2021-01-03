package com.kenvix.bookmgr.http.middleware

import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.Middleware
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.util.pipeline.PipelineContext

/**
 * 快速检查用户 Token
 */
object FastCheckUserToken : Middleware<User> {
    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): User {
        return CheckUserToken.check(pipeline.call, true)
    }
}