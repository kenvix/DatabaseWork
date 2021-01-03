package com.kenvix.bookmgr

import com.kenvix.bookmgr.server.WebServer
import com.kenvix.utils.event.EventSet
import com.kenvix.utils.event.eventSetOf
import com.kenvix.utils.preferences.ServerEnv
import org.apache.commons.dbcp2.BasicDataSource
import org.jooq.Configuration
import org.jooq.DSLContext
import org.litote.kmongo.coroutine.CoroutineDatabase
import java.io.File
import java.sql.Connection

object AppConstants {
    val ApiBaseUrl = ServerEnv.WebSiteUrl + ServerEnv.ApiBaseUrl

    var jooqConfiguration
        get() = WebServer.currentThreadJooqConfiguration
        set(value) { WebServer.currentThreadJooqConfiguration = value }

    val globalJooqConfiguration
        get() = WebServer.jooqConfiguration

    var jooqConfigurationOrNull: Configuration?
        get() = WebServer.currentThreadJooqConfigurationOrNull
        set(value) { WebServer.currentThreadJooqConfigurationOrNull = value }

    val mongoDatabase: CoroutineDatabase
        get() = WebServer.mongoDatabase

    init {
        if(System.getProperty("hotReloadSupported")?.toBoolean() == true)
            println("CREATED APP CONST INTANCE " + WebServer.hashCode() + " / LOADER " + javaClass.classLoader)
    }

    /**
     * Create a new jooq DSL context.
     * Note that you do NOT need to keep a reference to a DSLContext.
     * This method is delegated
     * @see WebServer.dslContext
     */
    val dslContext: DSLContext
        get() = WebServer.dslContext

    val dataSource: BasicDataSource
        get() = WebServer.dataSource

    val sqlConnection: Connection
        get() = dataSource.connection

    val startedAt = System.currentTimeMillis()

    val shutdownHandler: EventSet<Unit> = eventSetOf()

    val workingFolder = File("").absolutePath + File.separatorChar

    fun getApiUrl(path: String): String {
        return if (path.startsWith('/'))
            ApiBaseUrl + path.substring(1)
        else
            ApiBaseUrl + path
    }
}