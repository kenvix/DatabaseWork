package com.kenvix.bookmgr.server

import com.kenvix.utils.preferences.ServerEnv
import io.ktor.application.Application
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.util.KtorExperimentalAPI
import org.slf4j.LoggerFactory
import java.io.File

private val logger = LoggerFactory.getLogger("KtorServer")
private val workingFolder = File("").absolutePath + File.separatorChar

@KtorExperimentalAPI
val ktorEmbeddedServer = embeddedServer(CIO, ServerEnv.HttpPort, ServerEnv.HttpHost, watchPaths = run {
    if (ServerEnv.DebugMode && System.getProperty("hotReloadSupported")?.toBoolean() == true) {
        listOf( // Substring match rules for classpath
                "${workingFolder.replace('\\', '/')}out",
                "${workingFolder.replace('\\', '/')}build/classes",
                "/ServerMain/out/",
                "/ServerMain/build/classes/"
        ).also {
            logger.debug("Ktor auto reload enabled on: ${it.joinToString(" , ")}")
        }
    } else {
        emptyList()
    }
}, configure = {
    // Size of the event group for accepting connections
    connectionGroupSize = parallelism * ServerEnv.ServerWorkerPoolSizeRate
    // Size of the event group for processing connections,
    // parsing messages and doing engine's internal work
    workerGroupSize = parallelism * ServerEnv.ServerWorkerPoolSizeRate
    // Size of the event group for running application code
    callGroupSize = parallelism * ServerEnv.ServerWorkerPoolSizeRate

    /** Options for CIO **/

    /** Options for CIO **/
    // Number of seconds that the server will keep HTTP IDLE connections open.
    // A connection is IDLE if there are no active requests running.
    connectionIdleTimeoutSeconds = ServerEnv.ServerMaxIdleSecondsPerHttpConnection

    /** Options for Netty **/

    /** Options for Netty **/
    // Size of the queue to store [ApplicationCall] instances that cannot be immediately processed
    // requestQueueLimit = parallelism * ServerEnv.ServerWorkerPoolSizeRate
    // Do not create separate call event group and reuse worker group for processing calls
    // shareWorkGroup = true
    // Timeout in seconds for sending responses to client
    // responseWriteTimeoutSeconds = 120
    // configureBootstrap = {

    // }
}, module = Application::module)