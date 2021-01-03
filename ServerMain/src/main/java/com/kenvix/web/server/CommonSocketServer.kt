//--------------------------------------------------
// Class ApiSocketServer
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.web.server

import kotlinx.coroutines.*
import org.newsclub.net.unix.AFUNIXServerSocket
import org.newsclub.net.unix.AFUNIXSocketAddress
import java.io.File
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.function.Consumer
import kotlin.coroutines.CoroutineContext

open class CommonSocketServer : AutoCloseable, CoroutineScope {
    @Volatile @Transient
    var shouldExit: Boolean = false
        private set

    val serverSocket: ServerSocket
    val unixSocketFile: File?
    val socketAddress: InetSocketAddress

    val serverCoroutineJob = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + serverCoroutineJob

    constructor(unixSocketFilePath: String) : this(File(unixSocketFilePath))

    constructor(unixSocketFile: File) {
        this.unixSocketFile = unixSocketFile
        serverSocket = AFUNIXServerSocket.newInstance()
        socketAddress = AFUNIXSocketAddress(unixSocketFile)
    }

    constructor(port: Int, backlog: Int = 50, bindAddr: InetAddress? = null) {
        unixSocketFile = null
        serverSocket = ServerSocket(port, backlog, bindAddr)
        socketAddress = InetSocketAddress(bindAddr, port)
    }

    constructor(address: InetSocketAddress, backlog: Int = 50) {
        unixSocketFile = null
        serverSocket = ServerSocket(address.port, backlog, address.address)
        socketAddress = address
    }

    fun bind() = serverSocket.bind(socketAddress)

    fun listen(onAccept: Consumer<Socket>) {
        launch(Dispatchers.IO) {
            while (!shouldExit) {
                val accept = serverSocket.accept()

                launch(Dispatchers.IO) {
                    onAccept.accept(accept)
                }
            }
        }
    }

    override fun close() {
        shouldExit = true
        cancel("Server closed")
    }
}