//--------------------------------------------------
// Class BookType
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.contacts.generic

sealed class BookType {
    abstract val id: Int
    abstract val name: String
}

data class TopBookType(override val id: Int, override val name: String, val childMap: MutableMap<Int, BookType> = LinkedHashMap()) : BookType()
data class SecondBookType(override val id: Int, override val name: String, val top: TopBookType) : BookType()