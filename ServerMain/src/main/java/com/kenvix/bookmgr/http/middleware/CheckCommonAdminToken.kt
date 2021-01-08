package com.kenvix.bookmgr.http.middleware

import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.Middleware
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.validateValue
import io.ktor.application.ApplicationCall
import io.ktor.util.pipeline.PipelineContext
import javax.naming.AuthenticationException

object CheckCommonAdminToken : Middleware<User>() {
    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): User {
        val user = pipeline.middleware(CheckUserToken)
        return user.validateValue(AuthenticationException()) { user.accessLevel >= AccessLevel.CommonAdmin }
    }
}