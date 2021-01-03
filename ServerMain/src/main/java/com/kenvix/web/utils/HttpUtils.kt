@file:JvmName("HttpUtils")

package com.kenvix.web.utils

import com.kenvix.bookmgr.orm.enums.AttachmentType
import com.kenvix.bookmgr.server.CommonJsonResult
import com.kenvix.bookmgr.server.ErrorResult
import com.kenvix.utils.exception.CommonBusinessException
import com.kenvix.utils.preferences.ServerEnv
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.features.BadRequestException
import io.ktor.features.NotFoundException
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.http.content.streamProvider
import io.ktor.request.header
import io.ktor.request.userAgent
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.route
import io.ktor.util.pipeline.PipelineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.commons.io.FileUtils
import org.apache.commons.io.FilenameUtils
import org.apache.tika.config.TikaConfig
import org.apache.tika.metadata.Metadata
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.sql.Timestamp

private val utilsLogger = LoggerFactory.getLogger("HttpUtils")!!

fun Route.controller(path: String, controller: Controller) {
    this.route(path, controller::route)
}

fun <T> PipelineContext<*, ApplicationCall>.middleware(clazz: Middleware<T>): T {
    return clazz.handle(this)
}

suspend fun <T> PipelineContext<*, ApplicationCall>.middleware(clazz: MiddlewareSuspend<T>): T {
    return clazz.handle(this)
}

fun PipelineContext<*, ApplicationCall>.middleware(vararg clazz: Middleware<*>) {
    clazz.forEach { it.handle(this) }
}

suspend fun <T> PipelineContext<*, ApplicationCall>.middleware(vararg clazz: MiddlewareSuspend<*>) {
    clazz.forEach { it.handle(this) }
}

suspend fun PipelineContext<*, ApplicationCall>.respondJson(data: Any?, info: String? = null,
                                                            code: Int = 0, status: HttpStatusCode = HttpStatusCode.OK) {
    call.respond(CommonJsonResult(status.value, info = info ?: status.description, code = code, data = data))
}

suspend fun PipelineContext<*, ApplicationCall>.respondJsonText(jsonText: String,
                                                            status: HttpStatusCode = HttpStatusCode.OK) {
    call.respondText(jsonText, ContentType.Application.Json, status)
}

suspend fun PipelineContext<*, ApplicationCall>.respondSuccess(info: String? = null) {
    respondJson(null, info)
}

suspend fun PipelineContext<*, ApplicationCall>.respondError(code: HttpStatusCode, exception: Throwable? = null) {
    val userAgent = call.request.userAgent()
    var info = ""
    var trace = ""

    if (exception != null) {
        if (ServerEnv.DebugMode) {
            info = "${exception.javaClass.simpleName}: ${exception.message}"
            trace = exception.getStringStackTrace()
        } else {
            if (code.value in 400..499 || code.value != 501)
                info = exception.message ?: exception.hashCode().toString()
            else
                info = exception.hashCode().toString()
        }
    }

    if (userAgent != null && userAgent.contains("Mozilla", true) &&
            call.request.header("X-Requested-With") == null) {
        call.respond(code, FreeMarkerContent("error.ftl", mapOf(
                "code" to code.value,
                "description" to code.description,
                "info" to info,
                "trace" to trace
        )))
    } else {
        call.respond(code, CommonJsonResult(status = code.value, info = info,
                code = if (exception is CommonBusinessException) exception.code else code.value,
                data = ErrorResult(
                        exception = exception?.javaClass?.simpleName ?: "",
                        exceptionFullName = exception?.javaClass?.name ?: "",
                        trace = trace
                )
        ))
    }
}

val uploadTempPath: Path by lazy {
    if (System.getProperty("java.io.tmpdir").isNullOrBlank()) {
        File("_temp").apply {
            if (this.exists())
                this.mkdirs()
        }
        System.setProperty("java.io.tmpdir", "_temp")
    }

    if (ServerEnv.UploadTempDir.isBlank())
        Paths.get(System.getProperty("java.io.tmpdir"))
    else
        Paths.get(ServerEnv.UploadTempDir)
}

val uploadSavePath: Path = Paths.get(ServerEnv.UploadSaveDir)
val tikaConfig= TikaConfig()

suspend fun File.getFileType(expectedMime: String) = withContext(Dispatchers.IO) {
    val metadata = Metadata()
    metadata.set(Metadata.RESOURCE_NAME_KEY, name)
    val ext = FilenameUtils.getExtension(name)
    tikaConfig.detector.detect(inputStream(), metadata)
}

fun currentTimeStamp() = Timestamp(System.currentTimeMillis())

suspend fun <R> File.useTempFile(then: (suspend (File) -> R))
        = withContext(Dispatchers.IO) {

    try {
        then(this@useTempFile)
    } catch (exception: Throwable) {
        kotlin.runCatching { this@useTempFile.delete() }
                .onFailure { warn("Delete temp file failed", it, utilsLogger) }

        throw exception
    }
}

/**
 * Handle form upload
 * @return Temp file
 */
suspend fun PartData.FileItem.handleUpload(verify: ((File) -> Unit)? = null): File = withContext(Dispatchers.IO) {
    this@handleUpload.streamProvider().use { input ->
        val ext = FilenameUtils.getExtension(this@handleUpload.originalFileName)?.toLowerCase()
        if (ext.isNullOrBlank() || ext.length > 16)
            throw BadRequestException("Bad file extension name: $ext")

        runCatching { AttachmentType.valueOf(ext) }.onFailure {
            throw BadRequestException("File extension name $ext is not allowed")
        }

        val file = uploadTempPath
                .resolve("up-${System.currentTimeMillis()}-${System.nanoTime()}.$ext").toFile()
        file.outputStream().buffered().use { output -> input.copyTo(output) }

        if (FileUtils.sizeOf(file) > ServerEnv.MaxUploadSize)
            throw BadRequestException("File is too big")

        try {
            verify?.invoke(file)
            file
        } catch (throwable: Throwable) {
            file.runCatching { file.delete() }.onFailure { warn("Delete bad file failed", it, utilsLogger) }
            throw BadRequestException("Illegal uploaded file ${this@handleUpload.originalFileName}", throwable)
        }
    }
}

suspend fun saveTempAttachment(temp: File, hash: String, ext: String): File = withContext(Dispatchers.IO) {
    val dest = uploadSavePath.resolve("$hash.$ext").toFile()
    FileUtils.moveFile(temp, dest)
    dest
}

inline fun <T: Any> T?.validateValue(errorMessage: String, passCondition: (check: T) -> Boolean): T {
    if (this == null)
        throw BadRequestException("Illegal input data: Required form param not found")

    if (!passCondition(this))
        throw BadRequestException(errorMessage)

    return this
}

inline fun <T: Any> T?.validateValue(passCondition: (check: T) -> Boolean): T
        = validateValue("Illegal input data.", passCondition)


fun <T: Any> T?.assertNotNull(): T {
    if (this == null)
        throw BadRequestException("Illegal input data: Required data is null")

    return this
}

fun <T: Any> T?.assertExist(): T {
    if (this == null)
        throw NotFoundException("Specified data not exist")

    return this
}

inline fun <reified E : Enum<E>> validatedEnumValueOf(value: String?, default: E? = null): E {
    if (value.isNullOrEmpty()) {
        if (default == null)
            throw BadRequestException("${E::class.java.simpleName} cannot be empty")
        else
            return default
    }

    return enumValues<E>().find { it.name == value } ?:
    throw BadRequestException("Illegal value $value for ${E::class.java.simpleName}")
}