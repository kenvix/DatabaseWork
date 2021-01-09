package com.kenvix.bookmgr.http.utils

import io.ktor.locations.*


@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id}")
class AuthorIDLocation(val id: Long)