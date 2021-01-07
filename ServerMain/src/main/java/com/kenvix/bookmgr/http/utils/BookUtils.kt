package com.kenvix.bookmgr.http.utils

import io.ktor.locations.*

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class BookIDLocation(val id: Long)

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class BorrowIDLocation(val id: Long)