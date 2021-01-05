package com.kenvix.bookmgr.http.middleware

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.utils.preferences.ServerEnv
import com.kenvix.web.utils.Middleware
import com.kenvix.web.utils.assertExist
import com.kenvix.web.utils.assertNotNull
import com.kenvix.web.utils.validateValue
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.request.header
import io.ktor.util.pipeline.PipelineContext
import java.util.*

/**
 * 检查用户 Token （完整信息，效率低）
 */
object CheckUserToken : Middleware<User> {
    private val secretKey = ServerEnv.AuthSecretKey
    private val algorithm = Algorithm.HMAC256(secretKey)
    private val issuer = ServerEnv.AuthIssuer
    private val validityTimeMills = ServerEnv.AuthValidityTimeMills
    private const val passwordBeginIndex = 45
    private const val passwordPrefixLength = 9

    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): User {
        return check(pipeline.call)
    }

    fun check(call: ApplicationCall, fastCheck: Boolean = false): User {
//        try {
//            val verify = getVerifier().verify(call.request.header("Token").assertNotNull())
//            val uid = verify.getClaim("uid").asLong().validateValue { it > 0 }
//            val user = UserModel.run {
//                if(fastCheck)
//                    fetchOneBasicInformationByUid(uid)
//                else
//                    fetchOneByUid(uid)
//            }.assertExist()
//
//            user.password.substring(passwordBeginIndex, passwordBeginIndex + passwordPrefixLength)
//                    .validateValue { it == verify.getClaim("pt").asString() }
//
//            user.role.validateValue { it != AccessLevel.Banned && it != AccessLevel.Unknown }
//
//            return user
//        } catch (e: Exception) {
//            throw AuthenticationException("Auth token is wrong")
//        }
        TODO()
    }

    fun getVerifier(): JWTVerifier = JWT
            .require(algorithm)
            .withIssuer(issuer)
            .build()

    fun generateToken(user: User): String {
        return JWT.create()
                .withSubject("Auth")
                .withIssuer(issuer)
                .withClaim("uid", user.uid)
                .withClaim("tid", 0) //TODO: Implement TokenID to revoke a token
                .withClaim("pt", user.password.substring(passwordBeginIndex, passwordBeginIndex + passwordPrefixLength))
                .withExpiresAt(getExpiration())
                .sign(algorithm)
    }

    private fun getExpiration() = Date(System.currentTimeMillis() + validityTimeMills)
}