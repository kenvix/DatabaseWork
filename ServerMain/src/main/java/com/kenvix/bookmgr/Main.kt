@file:JvmName("Main")

package com.kenvix.bookmgr

import com.kenvix.web.utils.ConsoleCommands
import com.kenvix.web.utils.ExceptionHandler
import com.kenvix.bookmgr.server.WebServer
import com.kenvix.web.utils.error
import com.kenvix.utils.preferences.ServerEnv
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import kotlin.coroutines.CoroutineContext
import kotlin.system.exitProcess

object Main : CoroutineScope {
    private val mainJob = Job() + CoroutineName("Main")
    private val logger = LoggerFactory.getLogger(javaClass)

    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        logger.info("Application start: " + ServerEnv.AppName)
        logger.debug("Working directory: " + AppConstants.workingFolder)
        ExceptionHandler.registerGlobalExceptionHandler()
        registerCommands()
        registerShutdownHandler()
        parseCoreCommand(args) {
            launch(Dispatchers.IO) {
                runCatching {
                    logger.info("Starting web server ...")
                    WebServer.start()
                }.onFailure { showErrorAndExit(it, 2, "WebService initialized failed") }
            }

            beginReadSystemConsole()
        }
    }

    private fun parseCoreCommand(args: Array<String>, defaultAction: () -> Unit) {
        if (args.isEmpty()) {
            defaultAction()
        } else {
            when (args[0].lowercase()) {
                "dumpenv" -> {
                    logger.info("Dumping configurable environment variables ...")
                    ServerEnv.save()
                }

                "help" -> {
                    println("dumpenv - Dump configurable environment variables")
                    println("run - Run the application server")
                    println("help - Print this help")
                }

                "run" -> defaultAction()
            }
        }
    }

    @JvmOverloads
    fun showErrorAndExit(throwable: Throwable, exitCode: Int = 1, extraMessage: String? = null) {
        showErrorAndExit(
            message = extraMessage ?: throwable.localizedMessage,
            exitCode = exitCode,
            throwable = throwable
        )
    }

    @JvmOverloads
    fun showErrorAndExit(
        message: String,
        exitCode: Int = 1,
        throwable: Throwable? = null,
        simpleMessage: Boolean = false
    ) {
        val title = "Application Critical Error! Code #$exitCode"
        logger.error(title)

        when {
            throwable == null -> {
                logger.error(message)
            }

            simpleMessage -> {
                logger.error(message)
                logger.error(throwable.localizedMessage)
            }

            else -> {
                logger.error(message, throwable)
            }
        }

        exitProcess(exitCode)
    }

    private fun registerCommands() {
        ConsoleCommands["stop"] = {
            logger.info("Stopping application gracefully ...")
            exitProcess(0)
        }

        ConsoleCommands["halt"] = {
            logger.info("Halt VM now! (DISCARD all unsaved cached)")
            Runtime.getRuntime().halt(255)
        }

        ConsoleCommands["saveprop"] = {
            logger.info("Saving properties...")
            ServerEnv.save()
        }

        ConsoleCommands["help"] = {
            println("Available commands: ")
            ConsoleCommands.forEach { t, u -> print("$t ") }
            println()
        }

        ConsoleCommands["gc"] = {
            logger.info("Going to vm safe point and running garbage collection ...")
            System.gc()
        }
    }

    private fun registerShutdownHandler() {
        Runtime.getRuntime().addShutdownHook(Thread({
            logger.info("Preparing for shutdown ... ( enter 'halt' to discard all unsaved data and force quit )")
            AppConstants.shutdownHandler.forEach {
                kotlin.runCatching { it(Unit) }.onFailure { e -> logger.warn("Shutdown handler failed", e) }
            }
            logger.info("Application shutdown handler finished. can halt safely now.")
        }, "Shutdown Handler"))
    }

    private fun beginReadSystemConsole() {
        while (!Thread.interrupted()) {
            kotlin.runCatching {
                val input = readLine()

                if (input?.isNotBlank() == true) {
                    launch {
                        runCatching { ConsoleCommands.invoke(input) }.onFailure {
                            error("Command failed", it, logger)
                        }
                    }
                }
            }.onFailure { error("Console read line failed", it, logger) }
        }
    }

    override val coroutineContext: CoroutineContext = mainJob + Dispatchers.IO + CoroutineName("Main")
}