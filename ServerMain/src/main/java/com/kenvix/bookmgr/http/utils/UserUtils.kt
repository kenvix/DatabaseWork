@file:JvmName("UserUtils")

package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.AppConstants
import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.contacts.generic.IDResultDTO
import com.kenvix.bookmgr.contacts.generic.UserDTO
import com.kenvix.bookmgr.contacts.generic.UserId
import com.kenvix.bookmgr.http.middleware.CheckSuperAdminToken
import com.kenvix.bookmgr.http.middleware.CheckUserToken
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.bookmgr.orm.Routines
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.utils.exception.CommonBusinessException
import com.kenvix.web.utils.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import org.mindrot.jbcrypt.BCrypt
import java.net.URI
import java.util.regex.Pattern

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class UserIDLocation(val id: UserId)

fun User.toUserDTO(token: String? = null): UserDTO {
    return UserDTO(
            uid = this.uid,
            serialId = this.serialId,
            realName = this.realName,
            email = this.email ?: "",
            createdAt = this.createdAt.time,
            accessLevel = this.accessLevel,
            ipCreation = this.ipCreation,
            ipLogin = this.ipLogin,
            token = token
    )
}

fun User.toBasicUserDTO(): UserDTO {
    return UserDTO(
            uid = this.uid,
            serialId = this.serialId,
            realName = this.realName,
            accessLevel = this.accessLevel,
    )
}

fun UserDTO.toUser(): User {
    return User().apply {
        uid = this.uid
        serialId = this.serialId
        email = if(this.email.isBlank()) null else email
        createdAt = this.createdAt
        ipCreation = this.ipCreation
        realName = this.realName
        ipLogin = this.ipLogin
        accessLevel = this.accessLevel
    }
}

val User.isSuperAdmin
    get() = this.accessLevel == AccessLevel.SuperAdmin

private const val emailValidateRule = "^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$"
private val emailValidatePattern = Pattern.compile(emailValidateRule)

fun String.validateEmail() = this
        .trim()
        .validateValue { it.length in 0..70 }
        .validateValue { emailValidatePattern.matcher(it).matches() }

fun String.validatePhoneNumber() = this
        .trim()
        .replace(" ", "")
        .toLong()
        .run { if (this@validatePhoneNumber.startsWith('+')) -this else this }

fun String.toPasswordHash() = BCrypt.hashpw(this, BCrypt.gensalt())!!

internal val illegalUserNameRegex = Regex("<|>|@|:|\\|\\\\|\\?|\"|'|\\[")

/**
 * Create user
 */
internal suspend fun PipelineContext<Unit, ApplicationCall>.createUser() {
    val postParameters: Parameters = call.receiveParameters()

    val serialId = postParameters.getOrFail<String>("username").validateValue {
        it.length in 0..60 && !it.contains(illegalUserNameRegex)
    }.trim()

    val realName = postParameters.getOrFail<String>("realName").validateValue {
        it.length in 0..30 && !it.contains(illegalUserNameRegex)
    }.trim()

    val password = postParameters.getOrFail<String>("password").toPasswordHash()
    val email = postParameters["email"]?.validateEmail()

    if (email!= null && UserModel.isEmailExist(email))
        throw CommonBusinessException("Email have been used.", 1002)

    if (UserModel.isSerialIdExist(serialId))
        throw CommonBusinessException("ID have been used.", 1003)

    val uid = Routines.userAdd(
        AppConstants.jooqConfiguration,
        serialId,
        email,
        realName,
        password,
        AccessLevel.User,
        call.request.origin.remoteHost
    )

    val user = UserModel.fetchOneByUid(uid)
    respondSuccess("注册成功", user.toUserDTO(CheckUserToken.generateToken(user)), URI("/"))
}

/**
 * Delete user
 */
internal suspend fun PipelineContext<Unit, ApplicationCall>.deleteUser(userLocation: UserIDLocation) {
    val callerUser = middleware(CheckSuperAdminToken)
    UserModel.deleteById(userLocation.id)
    respondSuccess("删除用户成功", IDResultDTO(callerUser.uid), URI("/admin/user"))
}

/**
 * Get current user info
 * GET /user
 */
internal suspend fun PipelineContext<Unit, ApplicationCall>.getCurrentUserInfo() {
    respondJson(middleware(CheckUserToken).toUserDTO())
}

/**
 * Get specified user info
 * GET /user/{id}
 */
internal suspend fun PipelineContext<Unit, ApplicationCall>.getUserInfo(userLocation: UserIDLocation) {
    val user = UserModel.fetchOneByUid(userLocation.id).assertExist()
    respondJson(user.toUserDTO())
}

/**
 * Update user
 */
internal suspend fun PipelineContext<Unit, ApplicationCall>.updateUserInfo(userLocation: UserIDLocation) {
    val postParameters: Parameters = call.receiveParameters()

    val callerUser = middleware(CheckUserToken)
    if (userLocation.id != callerUser.uid)
        middleware(CheckSuperAdminToken)

    val user = callerUser.apply {
        uid = userLocation.id

        postParameters["email"].ifNotNull { email = it.validateEmail() }
        postParameters["password"].ifNotNull { password = it.toPasswordHash() }
        //postParameters["phone"].ifNotNull { phone = it.validatePhoneNumber() }
    }

    UserModel.update(user)
    respondSuccess("更新个人资料成功")
}