import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

val ktorVersion: String by project
val kotlinVersion: String by project
val kotlinxCoroutinesVersion: String by project
val logbackVersion: String by project

plugins {
    application
    java
    idea
    kotlin("jvm") version "1.4.21"
    id("de.fuerstenau.buildconfig") version "1.1.8"
    id("com.github.johnrengelman.shadow") version "5.2.0"
    //id("org.beryx.jlink") version "2.17.2"
    id("nu.studer.jooq") version "4.1"
    id("java-library")
}

group = "com.kenvix"
version = "3.0"
val applicationName = "Book-Manager"
val versionCode = 4
val archivesBaseName = "bookmgr"
val mainSrcDir = "src/main"
val testSrcDir = "src/test"
val generatedSrcDir = "generatedSrc"
val fullPackageName = "${group}.$archivesBaseName"
val fullPackagePath = fullPackageName.replace('.', '/')
val isReleaseBuild = System.getProperty("isReleaseBuild") != null
val systemProperties: java.util.Properties = System.getProperties()
val libDirName = "libs"
val mainClass = "${fullPackageName}.Main"


application {
    mainClassName = mainClass
}

repositories {
    mavenLocal()
    jcenter()
    google()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "https://repo.spring.io/libs-milestone")
    maven(url = "https://repo.spring.io/plugins-release")
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlin-js-wrappers") }
}

systemProperties.setProperty("project.jooqVersion", "3.13.1")
systemProperties.setProperty("project.jooqPropFile", "jooq.properties")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("io.ktor:ktor-server-cio:$ktorVersion")
//    implementation("io.ktor:ktor-server-netty:$ktorVersion")
//    implementation("io.ktor:ktor-server-jetty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-html-builder:$ktorVersion")
    implementation("io.ktor:ktor-freemarker:$ktorVersion")
    implementation("io.ktor:ktor-server-host-common:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-server-sessions:$ktorVersion")
    implementation("io.ktor:ktor-websockets:$ktorVersion")
//    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-auth-jwt:$ktorVersion")
    implementation("io.ktor:ktor-gson:$ktorVersion")
    implementation("io.ktor:ktor-network:$ktorVersion")
//    implementation("io.ktor:ktor-network-tls:$ktorVersion")

//    implementation("io.ktor:ktor-client-core:$ktor_version")
//    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
//    implementation("io.ktor:ktor-client-cio:$ktor_version")
//    implementation("io.ktor:ktor-client-websockets:$ktor_version")
//    implementation("io.ktor:ktor-client-logging-jvm:$ktor_version")

    // Server Metrics
    implementation("io.dropwizard.metrics:metrics-core:4.1.11")
    implementation("io.dropwizard.metrics:metrics-jmx:4.1.11")
    implementation("io.ktor:ktor-metrics:$ktorVersion")

    // micrometer and prometheus
    implementation("io.ktor:ktor-metrics-micrometer:$ktorVersion")
    implementation("io.micrometer:micrometer-core:1.5.3")
    implementation("io.micrometer:micrometer-registry-prometheus:1.5.3")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("io.github.cdimascio:java-dotenv:5.1.4")

    implementation("commons-io:commons-io:2.6")
    implementation("org.apache.tika:tika-core:1.24.1")
    // implementation("org.apache.tika:tika-parsers:1.24.1")

    implementation(group = "commons-cli", name = "commons-cli", version = "1.4")
//    implementation(group = "org.yaml", name = "snakeyaml", version = "1.21")
    implementation(fileTree("libs"))

    implementation("com.google.protobuf:protobuf-java:3.12.4")

    // https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api
    implementation(group = "javax.persistence", name = "javax.persistence-api", version = "2.2")
    //添加jooq依赖
    implementation(group = "org.jooq", name = "jooq", version = System.getProperty("project.jooqVersion"))
    //<!> 一定要添加所用数据库的依赖，否则会报错而且不告诉你原因
    // implementation(group = "org.xerial", name = "sqlite-jdbc", version = "3.25.2")
    implementation(group = "mysql", name = "mysql-connector-java", version = "8.0.22")
    jooqRuntime(group = "mysql", name = "mysql-connector-java", version = "8.0.22")

    //implementation("org.litote.kmongo:kmongo-coroutine:4.0.0")

    implementation(group = "org.apache.commons", name = "commons-dbcp2", version = "2.7.0")

    //Apache thrift
    //implementation("com.kohlschutter.junixsocket:junixsocket-core:2.3.2")
    //implementation("org.apache.thrift:libthrift:0.13.0")

    implementation("org.reflections:reflections:0.9.12")

    //bcrypt
    implementation("org.mindrot:jbcrypt:0.4")
    //implementation("org.apache.commons:commons-configuration2:2.7")

    implementation("com.google.guava:guava:29.0-jre")


}

kotlin.sourceSets["main"].kotlin.srcDirs(mainSrcDir)
kotlin.sourceSets["test"].kotlin.srcDirs(testSrcDir)

// Add generated build-config directories to the main source set, so that the
// IDE doesn"t complain when the app references BuildConfig classes
sourceSets {
    getByName("main").apply {
        java.srcDirs(
                File(mainSrcDir),
                File(buildDir, "gen/buildconfig/src"),
                File(buildDir, "src")
        )
        resources.srcDirs("$mainSrcDir/resources")
    }

    getByName("test").apply {
        java.srcDirs(
                File(testSrcDir),
                File(buildDir, "gen/buildconfig/src"),
                File(buildDir, "src")
        )
        resources.srcDirs("$testSrcDir/resources")
    }
}

/*********************************************************************/
/**                 Application Build Config Settings               **/
/*********************************************************************/

buildConfig {
    appName = project.name       // sets value of NAME field
    version = project.version.toString()   // sets value of VERSION field,
    // "unspecified" if project.version is not set

    clsName = "BuildConfig"      // sets the name of the BuildConfig class
    packageName = fullPackageName  // sets the package of the BuildConfig class,
    // "de.fuerstenau.buildconfig" if project.group is not set
    charset = "UTF-8"            // sets charset of the generated class,
    // "UTF-8" if not set otherwise

    buildConfigField("String", "APPLICATION_NAME", applicationName)
    buildConfigField("String", "VERSION_NAME",     version)
    buildConfigField("String", "PACKAGE_NAME",     fullPackageName)
    buildConfigField("int",    "VERSION_CODE",     versionCode.toString())
    buildConfigField("long",   "BUILD_UNIXTIME",   System.currentTimeMillis().toString() + "L")
    buildConfigField("java.util.Date", "BUILD_DATE", "new java.util.Date(" + System.currentTimeMillis() + "L)")
    buildConfigField("String", "BUILD_USER",       System.getProperty("user.name"))
    buildConfigField("String", "BUILD_JDK",        System.getProperty("java.version"))
    buildConfigField("String", "BUILD_OS",         System.getProperty("os.name"))
    buildConfigField("String", "LIBRARY_DIR_NAME", libDirName)
    buildConfigField("String", "MAIN_CLASS_NAME",  mainClass)
    buildConfigField("boolean","IS_RELEASE_BUILD", isReleaseBuild.toString())

    val jooqFile = project.file(System.getProperty("project.jooqPropFile"))
    if (jooqFile.exists()) {
        val props = Properties()
        props.load(jooqFile.inputStream())
        buildConfigField("String", "DATABASE_NAME", props.getProperty("jooq.srcDatabaseName"))
    }
}

/*********************************************************************/
/**                            Tasks                                **/
/*********************************************************************/

systemProperties.setProperty("project.fullPackageName", fullPackageName)
systemProperties.setProperty("project.fullPackagePath", fullPackagePath)
systemProperties.setProperty("project.applicationName", applicationName)
systemProperties.setProperty("project.versionCode", versionCode.toString())
systemProperties.setProperty("project.archivesBaseName", archivesBaseName)
systemProperties.setProperty("project.mainSrcDir", mainSrcDir)
systemProperties.setProperty("project.testSrcDir", testSrcDir)
systemProperties.setProperty("project.generatedSrcDir", generatedSrcDir)
systemProperties.setProperty("project.mainClassName", mainClass)

apply(from = "enableJooq.gradle")
//apply(from = "jlink.gradle")

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = sourceCompatibility
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        kotlinOptions.freeCompilerArgs += "-Xinline-classes"
    }

    withType<JavaCompile> {
        options.encoding = "utf-8"

        if (systemProperties.getProperty("project.generateORM") != null) {
            dependsOn("generateORM")
        } else {
            logger.info("Will not update jOOQ ORM at build time, please manually run generateORM gradle task or add -Dproject.generateORM=true to gradle JVM options")
        }
    }

    withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveBaseName.set(archivesBaseName)
//        archiveVersion.set(this@Build_gradle.version.toString())

        destinationDirectory.set(file("${buildDir}/output"))
        isZip64 = true
        minimize {
            exclude(dependency("mysql:mysql-connector-java:.*"))
            exclude(dependency("commons-logging:commons-logging:.*"))
            exclude(dependency("org.litote.kmongo:kmongo-coroutine:.*"))
        }
    }


    register("jarWithDepends", Jar::class.java) {
        dependsOn("copyJarLibs")
        destinationDir = file("${buildDir}/output")
        baseName = applicationName
        manifest {
            attributes(
                    mapOf(
                            "Implementation-Title" to project.name,
                            "Implementation-Version" to project.version,
                            "Main-Class" to mainClass,
                            "Class-Path" to configurations.runtimeClasspath.files.joinToString(" ") { "$libDirName/${it.name}" }
                    )
            )
        }
    }

    register("copyJarLibs", Copy::class.java) {
        doLast {
            into("${buildDir}/output/$libDirName")
            from(configurations.runtime)
        }
    }
}