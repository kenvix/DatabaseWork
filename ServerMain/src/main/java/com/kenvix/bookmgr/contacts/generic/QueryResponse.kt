//--------------------------------------------------
// Class QueryResponse
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------
@file:Suppress("unused")

package com.kenvix.bookmgr.contacts.generic

data class QueryResponse<T>(
    val status: Int = 0,
    val info: String = "",
    val data: T? = null
) {
    override fun toString(): String {
        return "#$status: $info <$data>"
    }
}

val <T> QueryResponse<T>.dataOrFail
    get() = data!!

fun <T> queryResponse(info: String, code: Int = 0, data: T? = null): QueryResponse<T> {
    return QueryResponse(code, info, data)
}

fun <T: Throwable> queryResponse(exception: T, code: Int = 1): QueryResponse<T> {
    return QueryResponse(code, exception.message
            ?: "", exception)
}

fun <T: Any> queryResponse(data: T, code: Int = 0): QueryResponse<T> {
    return QueryResponse(code, data.toString(), data)
}