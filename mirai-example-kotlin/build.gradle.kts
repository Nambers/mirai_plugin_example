plugins {
    val kotlinVersion = "1.4.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.0-M1-1"
}

group = "org.example"
version = "0.2.0"

repositories {
        //¹úÄÚ¾µÏñÔ´
    maven { url =uri("https://maven.aliyun.com/nexus/content/repositories/jcenter")}
    maven { url =uri("https://mirrors.huaweicloud.com/repository/maven") }
    maven { url =uri("https://dl.bintray.com/kotlin/kotlin-eap")}
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}
dependencies{
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21")
}