package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.middleware.FastCheckUserToken
import com.kenvix.bookmgr.http.utils.toUserDTO
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.utils.exception.InvalidAuthorizationException
import com.kenvix.web.utils.*
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.features.origin
import io.ktor.http.Parameters
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.request.receiveParameters
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.post
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.getOrFail
import io.ktor.util.pipeline.PipelineContext
import org.mindrot.jbcrypt.BCrypt
import java.sql.Timestamp

@OptIn(KtorExperimentalAPI::class, KtorExperimentalLocationsAPI::class)
object SessionController : ApiBaseController() {
    override fun route(route: Route) {
        route {
            post("/") { createSession() }
            delete("/") { deleteSession() }
        }
    }

    /**
     * Create session. aka login.
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.createSession() {
        val postParameters: Parameters = call.receiveParameters()
        val username = postParameters.getOrFail<String>("username").validateValue { it.isNotBlank() }
        val password = postParameters.getOrFail<String>("password").validateValue { it.isNotBlank() }

        val user = UserModel.fetchOneByEmailOrUserName(username).assertExist()

        if (!BCrypt.checkpw(password, user.password))
            throw InvalidAuthorizationException("Wrong password or username")

        user.loginIp = call.request.origin.remoteHost
        user.loginTime = Timestamp(System.currentTimeMillis())

        UserModel.update(user)

        respondJson(user.toUserDTO().apply {
            token = CheckUserToken.generateToken(user)
        })
    }

    /**
     * Delete current session, aka logout
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.deleteSession() {
        val user = middleware(FastCheckUserToken)
        respondSuccess("注销成功，再见，${user.name}")
    }
}