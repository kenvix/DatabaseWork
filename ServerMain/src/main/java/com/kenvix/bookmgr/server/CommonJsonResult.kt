package com.kenvix.bookmgr.server

data class CommonJsonResult(
        val status: Int,
        val code: Int = status,
        val info: String = "",
        val data: Any? = null
)