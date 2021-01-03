package com.kenvix.bookmgr.http.middleware

import com.kenvix.bookmgr.contacts.generic.Role
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.Middleware
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.validateValue
import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext
import javax.naming.AuthenticationException

object FastCheckAdminToken : Middleware<User> {
    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): User {
        val user = pipeline.middleware(FastCheckUserToken)
        return user.validateValue(AuthenticationException()) { user.role == Role.Admin }
    }
}