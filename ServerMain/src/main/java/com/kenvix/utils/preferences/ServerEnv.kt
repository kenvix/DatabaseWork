//--------------------------------------------------
// Class ServerProperties
//--------------------------------------------------
// Written by Kenvix <i@com.kenvix.com>
//--------------------------------------------------

package com.kenvix.utils.preferences

import com.kenvix.utils.annotation.Description

object ServerEnv : ManagedEnvFile() {
    @Description("站点名称")
    val AppName by envOf("Book-Manager")

    @Description("是否启用调试模式，生成环境务必为 false")
    val DebugMode: Boolean by envOf(false)

    @Description("上传文件临时目录，留空使用系统目录")
    val UploadTempDir: String by envOf("")

    val MaxUploadSize: Int by envOf(2097152000)

    @Description("默认上传保存路径")
    val UploadSaveDir: String by envOf("public/upload")

    @Description("站点地址")
    val WebSiteUrl: String by envOf("http://127.0.0.1:6449")
    val ApiBaseUrl: String by envOf("/api")

    val AsyncRequestTimeout by envOf(10000L)
    val PublicDirUrl by envOf("/api-public")
    val PublicDirPath by envOf("public")
    val RequestCacheSize by envOf(10240000L)
    val CorsOriginAnyHost by envOf(false)
    val CorsOriginHosts by envOf("")

    @Description("HTTP 数据库地址")
    val HttpHost: String by envOf( "127.0.0.1")
    @Description("HTTP 数据库端口")
    val HttpPort: Int by envOf(6449)

    @Description("MySQL 数据库地址")
    val DatabaseHost: String by envOf("127.0.0.1")
    @Description("MySQL 数据库端口")
    val DatabasePort: Int by envOf(3306)
    @Description("MySQL 数据库名称")
    val DatabaseName by envOf("book")
    @Description("MySQL 数据库用户")
    val DatabaseUser by envOf("root")
    @Description("MySQL 数据库密码")
    val DatabasePassword by envOf( "")

    @Description("API 签名验证密钥")
    val AuthSecretKey by envOf("ExampleAuthSecretKey")
    val AuthIssuer by envOf("MoeNet Co,. Ltd")
    val AuthValidityTimeMills: Long by envOf(36000 * 24 * 30L)

    @Description("是否启用 XForwardedHeaders 支持，若没有反向代理务必为 false")
    val XForwardedHeadersSupport by envOf(false)

    @Description("是否启用压缩")
    val EnableCompression by envOf(false)

    @Description("是否启用DataConversion")
    val EnableDataConversion by envOf(false)

    @Description("HTTP 服务器连接池大小倍率")
    val ServerWorkerPoolSizeRate: Int by envOf(50)

    val ServerMaxIdleSecondsPerHttpConnection: Int by envOf(120)

    val EnableMetrics: Boolean by envOf(false)
    val MetricsKey: String by envOf("")
    val EnableCallLogging: Boolean by envOf(false)

    val BackendHost by envOf("127.0.0.1")
    val BackendPort by envOf(54412)
    val BackendConnectTimeOut by envOf(10_000)
    val BackendReadTimeOut by envOf(0)

    val CacheCleanUpCheckIntervalSeconds: Long by envOf(1000 * 10)
}