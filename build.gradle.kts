plugins {
    val kotlinVersion = "1.5.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.7.0"
}

group = "org.example"
version = "0.1.0"

repositories {
    mavenLocal()
    maven{ url =uri("https://maven.aliyun.com/nexus/content/groups/public/")}
    mavenCentral()
}