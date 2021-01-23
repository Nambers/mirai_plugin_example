plugins {
    val kotlinVersion = "1.4.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.0.0"
}

group = "org.example"
version = "0.1.0"

repositories {
    //国内镜像源
    maven { url =uri("https://mirrors.huaweicloud.com/repository/maven") }
    maven { url =uri("https://maven.aliyun.com/nexus/content/repositories/jcenter")}
    maven { url =uri("https://dl.bintray.com/kotlin/kotlin-eap")}
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}
dependencies{
    //在IDE内运行的mcl添加滑块模块，参考https://github.com/project-mirai/mirai-login-solver-selenium
    //runtimeOnly("net.mamoe:mirai-login-solver-selenium:1.0-dev-15")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21")
}