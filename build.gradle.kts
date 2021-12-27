plugins {
    val kotlinVersion = "1.5.32"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.8.3"
}

group = "org.example"
version = "0.1.0"

repositories {
    mavenLocal()
    maven{ url =uri("https://maven.aliyun.com/nexus/content/groups/public/")}
    mavenCentral()
}