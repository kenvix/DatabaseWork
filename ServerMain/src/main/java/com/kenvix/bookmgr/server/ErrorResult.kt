//--------------------------------------------------
// Class ErrorResult
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.bookmgr.server

data class ErrorResult(
        val exception: String = "",
        val exceptionFullName: String = "",
        val trace: String = ""
)