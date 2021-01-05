@file:Suppress("unused")

package com.kenvix.bookmgr.contacts.generic

data class UserDTO (
        val uid: UserId,
        val serialId: String,
        val email: String = "",
        val realName: String = "",
        val accessLevel: Byte = AccessLevel.Banned,
        val createdAt: Long = 0,
        val ipCreation: String = "",
        val ipLogin: String = "",
        var token: String? = null
)

data class IDResultDTO(val id: UserId)