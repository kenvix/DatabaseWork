@file:JvmName("LaunchWrapper")

import com.kenvix.bookmgr.BuildConfig
import com.kenvix.bookmgr.server.ktorEmbeddedServer
import io.ktor.util.KtorExperimentalAPI

object LaunchWrapper {
    @KtorExperimentalAPI
    @JvmStatic
    fun main(args: Array<String>) {
        println("Ktor Project LaunchWrapper by Kenvix")
        System.getProperties().setProperty("hotReloadSupported", "true")
        val loader = ktorEmbeddedServer.environment.classLoader
        Thread.currentThread().contextClassLoader = loader

        val main = loader.loadClass(BuildConfig.MAIN_CLASS_NAME)
        main.getMethod("main", Array<String>::class.java).invoke(null, args)
    }
}