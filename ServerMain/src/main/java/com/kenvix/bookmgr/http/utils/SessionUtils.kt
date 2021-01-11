package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.utils.exception.InvalidAuthorizationException
import com.kenvix.web.utils.assertExist
import com.kenvix.web.utils.middleware
import com.kenvix.web.utils.respondSuccess
import com.kenvix.web.utils.validateValue
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.util.*
import io.ktor.util.date.*
import io.ktor.util.pipeline.*
import org.mindrot.jbcrypt.BCrypt
import java.net.URI

internal object SessionControllerUtils {
    /**
     * Create session. aka login.
     */
    internal suspend fun PipelineContext<Unit, ApplicationCall>.createSession() {
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
        call.response.cookies.append(
            Cookie(
                name = CheckUserToken.TokenKey,
                value = token,
                maxAge = ((if (isRemembered) CheckUserToken.validityTimeMills else CheckUserToken.validityTimeMills) / 1000).toInt(),
                expires = GMTDate(CheckUserToken.getExpiration(isRemembered).time)
            )
        )

        respondSuccess("登录成功", user.toUserDTO(token), URI("/"))
    }

    /**
     * Delete current session, aka logout
     */
    internal suspend fun PipelineContext<Unit, ApplicationCall>.deleteSession() {
        val user = middleware(CheckUserToken)
        CheckUserToken.markTokenInvalid(CheckUserToken.getToken(call))
        call.response.cookies.append(
            Cookie(
                name = CheckUserToken.TokenKey,
                value = "",
                maxAge = 0,
                expires = GMTDate.START
            )
        )
        respondSuccess("注销成功，再见，${user.realName}", redirectURI = URI("/user/login"))
    }
}