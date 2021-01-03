@file:JvmName("WebServerBasicRoutes")

package com.kenvix.bookmgr.server

import com.kenvix.utils.lang.toUnit
import com.kenvix.utils.preferences.ServerEnv
import com.kenvix.web.server.KtorModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.http.content.files
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.routing
import io.ktor.sessions.Sessions
import org.slf4j.LoggerFactory

@Suppress("unused", "DuplicatedCode") // Referenced in application.conf
internal object WebServerBasicRoutes : KtorModule {
    val logger = LoggerFactory.getLogger(javaClass)

    override fun module(application: Application, testing: Boolean) = application.apply {
        install(Sessions) {

        }

        routing {
            static(ServerEnv.PublicDirUrl) {
                files(ServerEnv.PublicDirPath)
                resources("public")
            }
        }
    }.toUnit()
}