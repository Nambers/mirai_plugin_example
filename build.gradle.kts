plugins {
    val kotlinVersion = "1.4.30"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("net.mamoe.mirai-console") version "2.4.0"
}

group = "org.example"
version = "0.1.0"

repositories {
    jcenter()
    //国内镜像源
    //华为云
    maven { url =uri("https://mirrors.huaweicloud.com/repository/maven") }
    //阿里云
    maven { url =uri("https://maven.aliyun.com/nexus/content/repositories/jcenter")}
    //mirai-console的仓库
    maven {url = uri("https://dl.bintray.com/him188moe/mirai")}
    //滑动模块的仓库
    // maven { url = uri("https://dl.bintray.com/karlatemp/misc") }
    mavenLocal()
    mavenCentral()
}
dependencies{
    //在IDE内运行的mcl添加滑块模块，请参考https://github.com/project-mirai/mirai-login-solver-selenium把版本更新为最新
    //runtimeOnly("net.mamoe:mirai-login-solver-selenium:1.0-dev-15")
}