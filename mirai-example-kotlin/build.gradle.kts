plugins {
    val kotlinVersion = "1.4.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.0.0"
}

mirai { // this: MiraiConsoleExtension
    // 可指定mirai-core配置，
    //参考 https://github.com/mamoe/mirai-console/blob/master/tools/gradle-plugin/README.md#%E9%85%8D%E7%BD%AE
    coreVersion = "2.1.0" // 修改 mirai-core 版本
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
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.21")
}