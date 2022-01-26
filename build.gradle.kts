plugins {
    val kotlinVersion = "1.5.32"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.10.0-RC2"
}

group = "org.example"
version = "0.1.0"

repositories {
    mavenLocal()
    maven("https://repo.mirai.mamoe.net/snapshots")
    maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public/") }
    mavenCentral()
}