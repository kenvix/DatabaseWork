//--------------------------------------------------
// Class Alias
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------
@file:Suppress("unused", "MemberVisibilityCanBePrivate")
package com.kenvix.bookmgr.contacts.generic

object AccessLevel {
    const val Banned: Byte = 0
    const val User: Byte = 10
    const val VIP: Byte = 20
    const val CommonAdmin: Byte = 100
    const val SuperAdmin: Byte = 127
}

object Sex {
    const val Unknown: Byte = 0
    const val Male: Byte = 1
    const val Female: Byte = 2
    const val Other: Byte = 3
}