package com.kenvix.web.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.thrift.TServiceClient
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TNonblockingServerSocket
import org.apache.thrift.transport.TNonblockingSocket
import org.apache.thrift.transport.TSocket
import org.newsclub.net.unix.AFUNIXSocket
import org.newsclub.net.unix.AFUNIXSocketAddress
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.File
import java.lang.IllegalArgumentException
import java.lang.reflect.ParameterizedType
import java.net.InetSocketAddress
import java.net.Socket
import java.nio.channels.Channel
import java.nio.channels.SocketChannel

@Suppress("MemberVisibilityCanBePrivate", "unused")

/**
 * Backend IPC Connector
 *
 * @param backendHost Host address of backend. If starts with unix:, it will be considered as UNIX Socket path
 * @param backendPort Port of backend. If backendHost is unix socket path, it will be ignored
 */
class BackendConnector <T: TServiceClient> (
        val clientClass: Class<T>,
        val backendHost: String,
        val backendPort: Int,
        val connectTimeout: Int = 5000,
        val readTimeout: Int = 0
) : Closeable {

    lateinit var client: T
        private set

    private lateinit var socket: Closeable
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun connect() = withContext(Dispatchers.IO) {
        logger.info("Connecting to backend on $backendHost:$backendPort")

        socket = if (backendHost.startsWith("unix:")) {
            // Unstable, test only.
            logger.warn("Unix socket backend is used for test only.")

            AFUNIXSocket.newInstance().apply {
                soTimeout = readTimeout
                connect(AFUNIXSocketAddress(File(backendHost.substring("unix:".length))), connectTimeout)
            }
        } else {
            TNonblockingSocket(backendHost, backendPort, connectTimeout)
        }

        val transportSocket = socket.let {
            when (it) {
                is Socket -> TNonblockingSocket(it.channel)
                is SocketChannel -> TNonblockingSocket(it)
                is TNonblockingSocket -> it
                else -> throw IllegalArgumentException("Unknown socket type")
            }
        }

        val transport = TFramedTransport(transportSocket)
        val protocol = TBinaryProtocol(transport)
        client = clientClass.getConstructor(TProtocol::class.java).newInstance(protocol)

        transportSocket.setTimeout(connectTimeout)

        try {
            if (clientClass.getDeclaredMethod("ping", String::class.java).invoke(client, "hello") == "hello") {
                logger.info("Backend connected")
            } else {
                throw IllegalStateException("Unrecognized backend reply. expected hello")
            }
        } catch (ignored: Exception) {
            logger.debug("Backend has no ping(String) method or inaccessible, ignored connection test.")
        }

        client
    }

    override fun close() {
        GlobalScope.launch { closeAndWait() }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun closeAndWait() = withContext(Dispatchers.IO) {
        socket.close()
    }
}