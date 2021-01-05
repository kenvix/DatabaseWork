package com.kenvix.bookmgr.http.controller.api

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.http.utils.toUserDTO
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.utils.exception.InvalidAuthorizationException
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.util.*
import io.ktor.util.date.*
import io.ktor.util.pipeline.*
import org.mindrot.jbcrypt.BCrypt

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
        val isRemembered = postParameters["remember"] != null

        val user = UserModel.fetchOneByEmailOrSerialId(username).assertExist()

        if (!BCrypt.checkpw(password, user.password))
            throw InvalidAuthorizationException("Wrong password or username")

        user.ipLogin = call.request.origin.remoteHost

        UserModel.update(user)
        val token = CheckUserToken.generateToken(user, isRemembered)
        call.response.cookies.append(Cookie(
            name = CheckUserToken.TokenKey,
            value = token,
            maxAge = ((if (isRemembered) CheckUserToken.validityTimeMills else CheckUserToken.validityTimeMills) / 1000).toInt(),
            expires = GMTDate(CheckUserToken.getExpiration(isRemembered).time)
        ))

        respondJson(user.toUserDTO(token))
    }

    /**
     * Delete current session, aka logout
     */
    private suspend fun PipelineContext<Unit, ApplicationCall>.deleteSession() {
        val user = middleware(CheckUserToken)
        CheckUserToken.markTokenInvalid(CheckUserToken.getToken(call))
        call.response.cookies.append(Cookie(
            name = CheckUserToken.TokenKey,
            value = "",
            maxAge = 0,
            expires = GMTDate.START
        ))
        respondSuccess("注销成功，再见，${user.realName}")
    }
}