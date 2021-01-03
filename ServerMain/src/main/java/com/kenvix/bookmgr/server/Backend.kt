package com.kenvix.bookmgr.server

import com.kenvix.bookmgr.pb.BackendBridge
import com.kenvix.utils.preferences.ServerEnv
import com.kenvix.web.utils.BackendConnector
import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

@Suppress("MemberVisibilityCanBePrivate")
object Backend : CoroutineScope, Closeable {
    val connector = BackendConnector<BackendBridge.Client>(
            backendHost = ServerEnv.BackendHost,
            backendPort = ServerEnv.BackendPort,
            connectTimeout = ServerEnv.BackendConnectTimeOut,
            readTimeout = ServerEnv.BackendReadTimeOut,
            clientClass = BackendBridge.Client::class.java
    )

    private val job = Job() + CoroutineName("Backend")

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    val client
        get() = connector.client

    fun connect() {
        launch { connectAndWait() }
    }

    suspend fun connectAndWait() = connector.connect()

    fun connectAndRetry() {
        launch {
            while (job.isActive) {
                try {
                    connectAndWait()
                } catch (e: Throwable) {
                    logger.error("Backend connection failed, will retry after 1s", e)
                    delay(1000)
                }
            }
        }
    }

    override val coroutineContext: CoroutineContext = job + Dispatchers.IO + CoroutineName("Main")

    override fun close() {
        job.cancel()
        connector.close()
    }
}