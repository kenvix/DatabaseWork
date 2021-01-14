package com.kenvix.bookmgr.http.middleware

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheStats
import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.utils.exception.InvalidAuthorizationException
import com.kenvix.utils.preferences.ServerEnv
import com.kenvix.web.server.Cached
import com.kenvix.web.server.CachedClasses
import com.kenvix.web.utils.Middleware
import com.kenvix.web.utils.assertExist
import com.kenvix.web.utils.assertNotNull
import com.kenvix.web.utils.validateValue
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.auth.*
import io.ktor.request.header
import io.ktor.util.pipeline.PipelineContext
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * 检查用户 Token （已缓存）
 */
object CheckUserToken : Middleware<User>(), Cached {
    private val secretKey = ServerEnv.AuthSecretKey
    private val algorithm = Algorithm.HMAC256(secretKey)
    private val issuer = ServerEnv.AuthIssuer
    val validityTimeMills = ServerEnv.AuthValidityTimeMills
    val validityTimeMillsShort = ServerEnv.AuthValidityTimeMillsShort
    private const val passwordBeginIndex = 45
    private const val passwordPrefixLength = 9
    const val TokenKey = "Token"
    val userTokenCheckCache: Cache<String, User> = CacheBuilder
        .newBuilder()
        .expireAfterAccess(10, TimeUnit.MINUTES)
        .build<String, User>()
    val invalidUserPlaceHolder: User = User().setUid(-1)

    init {
        CachedClasses.add(this)
    }

    override fun handle(pipeline: PipelineContext<*, ApplicationCall>): User {
        return check(pipeline.call)
    }

    fun markTokenInvalid(token: String) {
        userTokenCheckCache.put(token, invalidUserPlaceHolder)
    }

    fun getToken(call: ApplicationCall): String {
        var token: String? = null
        token = call.request.header(TokenKey)
        if (token != null)
            return token

        token = call.request.cookies[TokenKey]
        if (token != null)
            return token;

        throw InvalidAuthorizationException("您必须先登录")
    }

    fun check(call: ApplicationCall): User {
        val token = getToken(call)

        try {
            val cache = userTokenCheckCache.getIfPresent(token)

            if (cache == null) {
                val verify = getVerifier().verify(token)
                val uid = verify.getClaim("uid").asLong().validateValue { it > 0 }
                val user = UserModel.run {
                    fetchOneByUid(uid)
                }.assertExist()

                user.password.substring(passwordBeginIndex, passwordBeginIndex + passwordPrefixLength)
                    .validateValue { it == verify.getClaim("pt").asString() }

                user.accessLevel.validateValue { it != AccessLevel.Banned }
                userTokenCheckCache.put(token, user)
                return user
            } else {
                cache.validateValue { cache !== invalidUserPlaceHolder }
                return cache
            }
        } catch (e: Exception) {
            markTokenInvalid(token)
            throw InvalidAuthorizationException("Please login first", e)
        }
    }

    fun getVerifier(): JWTVerifier = JWT
            .require(algorithm)
            .withIssuer(issuer)
            .build()

    fun generateToken(user: User, useLongLifeTime: Boolean = false): String {
        return JWT.create()
                .withSubject("Auth")
                .withIssuer(issuer)
                .withClaim("uid", user.uid)
                .withClaim("tid", 0) //TODO: Implement TokenID to revoke a token
                .withClaim("pt", user.password.substring(passwordBeginIndex, passwordBeginIndex + passwordPrefixLength))
                .withExpiresAt(getExpiration(useLongLifeTime))
                .sign(algorithm)
    }

    fun getExpiration(useLongLifeTime: Boolean = false) =
        Date(System.currentTimeMillis() + if (useLongLifeTime) validityTimeMills else validityTimeMillsShort)

    override fun invalidateAll() {
        userTokenCheckCache.invalidateAll()
    }

    override fun cleanUpAll() {
        userTokenCheckCache.cleanUp()
    }

    override fun getStats(): List<CacheStats> {
        return listOf(userTokenCheckCache.stats())
    }
}