@file:JvmName("UserUtils")

package com.kenvix.bookmgr.http.utils

import com.kenvix.bookmgr.contacts.generic.Role
import com.kenvix.bookmgr.contacts.generic.UserDTO
import com.kenvix.bookmgr.contacts.generic.UserId
import com.kenvix.bookmgr.contacts.server.PersonPO
import com.kenvix.bookmgr.model.mongo.PersonDocument
import com.kenvix.bookmgr.model.mysql.UserModel
import com.kenvix.bookmgr.orm.tables.pojos.User
import com.kenvix.web.utils.validateValue
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.litote.kmongo.id.toId
import org.mindrot.jbcrypt.BCrypt
import java.util.regex.Pattern

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class UserIDLocation(val id: UserId)

fun User.toUserDTO(token: String? = null): UserDTO {
    return UserDTO(
            uid = this.uid,
            name = this.name,
            email = this.email ?: "",
            createTime = this.createTime.time,
            phone = this.phone,
            createIp = this.createIp,
            loginTime = this.loginTime.time,
            loginIp = this.loginIp,
            role = this.role,
            personId = this.mongoKey,
            token = token
    )
}

fun User.toBasicUserDTO(): UserDTO {
    return UserDTO(
            uid = this.uid,
            name = this.name,
            createTime = this.createTime.time,
            loginTime = this.loginTime.time,
            role = this.role,
            personId = this.mongoKey
    )
}

fun UserDTO.toUser(): User {
    return User().apply {
        uid = this.uid
        name = this.name
        email = if(this.email.isBlank()) null else email
        createTime = this.createTime
        loginTime = this.loginTime
        createIp = this.createIp
        loginIp = this.loginIp
        role = this.role
    }
}

fun getUserIdToMongoKeyListFromUserIdsString(uidList: List<String>?): Map<UserId, Id<PersonPO>> {
    return uidList?.mapNotNull {
        val uid = it.toLong()
        val key = UserModel.fetchOneBasicInformationByUid(uid)?.mongoKey
        if (key != null) uid to ObjectId(key).toId<PersonPO>() else null
    }?.toMap() ?: emptyMap()
}

suspend fun User.getPerson() = PersonDocument.findOneByMongoKey(mongoKey)

val User.isAdmin
    get() = this.role == Role.Admin

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