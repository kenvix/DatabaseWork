@file:JvmName("WebServerModules")
package com.kenvix.bookmgr.server

import com.codahale.metrics.jmx.JmxReporter
import com.kenvix.utils.exception.*
import com.kenvix.utils.preferences.ServerEnv
import com.kenvix.web.utils.respondError
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.features.BadRequestException
import io.ktor.features.NotFoundException
import io.ktor.freemarker.FreeMarker
import io.ktor.gson.gson
import io.ktor.http.CacheControl
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.cio.websocket.pingPeriod
import io.ktor.http.cio.websocket.timeout
import io.ktor.http.content.CachingOptions
import io.ktor.locations.Locations
import io.ktor.metrics.dropwizard.DropwizardMetrics
import io.ktor.metrics.micrometer.MicrometerMetrics
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.util.date.GMTDate
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.apache.http.auth.AuthenticationException
import org.jooq.exception.DataAccessException
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import java.sql.SQLException
import java.time.Duration
import java.util.concurrent.TimeUnit

@Suppress("unused", "DuplicatedCode") // Referenced in application.conf
fun Application.module() {
    val isTesting = System.getProperty("testing")?.toBoolean() ?: false

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        setSharedVariable("public", ServerEnv.PublicDirUrl)
    }

    install(Locations) {

    }

    if (ServerEnv.EnableCompression) {
        install(Compression) {
            gzip {
                priority = 1.0
            }
            deflate {
                priority = 10.0
                minimumSize(1024) // condition
            }
        }
    }

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)

        //header(HttpHeaders.Authorization)
        //header("MyCustomHeader")
        allowCredentials = true

        if (ServerEnv.CorsOriginAnyHost)
            anyHost()

        if (ServerEnv.CorsOriginHosts.isNotBlank())
            ServerEnv.CorsOriginHosts.split(',').forEach { host(it) }
    }

    install(CachingHeaders) {
        options { outgoingContent ->
            when (outgoingContent.contentType?.withoutParameters()) {
                ContentType.Text.CSS -> CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 24 * 60 * 60), expires = null as? GMTDate?)
                else -> null
            }
        }
    }

    if (ServerEnv.EnableDataConversion) {
        install(DataConversion)
    }

    install(DefaultHeaders) {
        //header("X-Engine", "Ktor") // will send this header with each response
    }

    if (ServerEnv.XForwardedHeadersSupport) {
        install(XForwardedHeaderSupport)

        WebServerBasicRoutes.logger.info("X-Forwarded-For Header Support is enabled. be aware of being spoofed by a malicious client")
    }

    install(io.ktor.websocket.WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    install(PartialContent) {
        // Maximum number of ranges that will be accepted from a HTTP request.
        // If the HTTP request specifies more ranges, they will all be merged into a single range.
        maxRangeCount = 10
    }

    // Easy '304 Not Modified' Responses
    install(ConditionalHeaders)

    // Enable Automatic HEAD Responses
    install(AutoHeadResponse)

    install(ContentNegotiation) {
        gson {
        }
    }

    if (ServerEnv.DebugMode || ServerEnv.EnableCallLogging) {
        install(CallLogging) {
            level = Level.DEBUG
            logger = LoggerFactory.getLogger("CallLogging")
        }
    }

    if (ServerEnv.EnableMetrics) {
        install(DropwizardMetrics) {
            JmxReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build()
                .start()
        }
        WebServerBasicRoutes.logger.info("JMXRemote Support is enabled")
        install(MicrometerMetrics) {
            val prometheusMeterRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
            registry = prometheusMeterRegistry
            routing {
                route(ServerEnv.ApiBaseUrl) {
                    get("/metrics/${ServerEnv.MetricsKey}") {
                        call.respondText(prometheusMeterRegistry.scrape())
                    }
                }
            }
        }
    }

    install(StatusPages) {
        exception<BadRequestException> { respondError(HttpStatusCode.BadRequest, it) }
        exception<InvalidResultException> { respondError(HttpStatusCode.BadRequest, it) }
        exception<NumberFormatException> { respondError(HttpStatusCode.BadRequest, it) }
        exception<com.kenvix.utils.exception.BadRequestException> { respondError(HttpStatusCode.BadRequest, it) }

        exception<AuthenticationException> { respondError(HttpStatusCode.Unauthorized, it) }
        exception<InvalidAuthorizationException> { respondError(HttpStatusCode.Unauthorized, it) }

        exception<ForbiddenOperationException> { respondError(HttpStatusCode.Forbidden, it) }
        exception<CommonBusinessException> { respondError(HttpStatusCode.NotAcceptable, it) }

        exception<NotFoundException> { respondError(HttpStatusCode.NotFound, it) }
        exception<com.kenvix.utils.exception.NotFoundException> { respondError(HttpStatusCode.NotFound, it) }

        exception<TooManyRequestException> { respondError(HttpStatusCode.TooManyRequests, it) }
        exception<NotSupportedException> { respondError(HttpStatusCode.UnsupportedMediaType, it) }

        exception<NotImplementedError> { respondError(HttpStatusCode.NotImplemented, it) }

        exception<DataAccessException> {
            com.kenvix.web.utils.error("MySQL Database failed!", it, WebServerBasicRoutes.logger)
            respondError(HttpStatusCode.InternalServerError, it)
        }

        exception<SQLException> {
            com.kenvix.web.utils.error("Database failed!", it, WebServerBasicRoutes.logger)
            respondError(HttpStatusCode.InternalServerError, it)
        }

        exception<Throwable> {
            com.kenvix.web.utils.error("HTTP request failed unexpectedly", it, WebServerBasicRoutes.logger)
            respondError(HttpStatusCode.InternalServerError, it)
        }

        status(HttpStatusCode.BadRequest, HttpStatusCode.Unauthorized, HttpStatusCode.Forbidden,
                HttpStatusCode.NotFound, HttpStatusCode.TooManyRequests, HttpStatusCode.InternalServerError,
                HttpStatusCode.MethodNotAllowed, HttpStatusCode.NotAcceptable, HttpStatusCode.RequestTimeout,
                HttpStatusCode.Gone, HttpStatusCode.UnsupportedMediaType, HttpStatusCode.BadGateway,
                HttpStatusCode.PayloadTooLarge, HttpStatusCode.NotImplemented, HttpStatusCode.ServiceUnavailable,
                HttpStatusCode.UpgradeRequired, HttpStatusCode.Locked) { respondError(it) }
    }

    WebServer.registerRoutes(this, isTesting)
}