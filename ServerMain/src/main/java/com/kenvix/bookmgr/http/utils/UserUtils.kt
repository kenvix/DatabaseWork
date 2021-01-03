@file:JvmName("UserUtils")

package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.contacts.generic.AccessLevel
import com.kenvix.bookmgr.contacts.generic.UserDTO
import com.kenvix.bookmgr.contacts.generic.UserId
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.validateValue
import io.ktor.locations.*
import org.mindrot.jbcrypt.BCrypt
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