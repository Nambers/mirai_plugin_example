package org.example.mirai.plugin

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.Listener
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.NewFriendRequestEvent
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.utils.info
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.PlainText
import kotlin.coroutines.EmptyCoroutineContext

/*
在src/main/resources/plugin.yml里改插件信息和入口点
在settings.gradle.kts里改生成的插件.jar名称
用runmiraikt这个配置可以在ide里运行，不用复制到mcl或其他启动器
 */

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.example.mirai-example",
        version = "0.1.0"
    )
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }
        //配置文件目录 "${dataFolder.absolutePath}/"

        globalEventChannel().subscribeAlways(
            GroupMessageEvent::class,
            EmptyCoroutineContext,
            Listener.ConcurrencyKind.CONCURRENT
        ) {
            //群消息
            if (message.contentToString().startsWith("复读")) {
                group.sendMessage(message.contentToString().replace("复读", ""))
            }
            if (message.contentToString() == "hi") {
                group.sendMessage("hi")
            }
            message.forEach {
                //循环每个元素在消息里
                if (it is Image) {
                    //如果消息这一部分是图片
                }
                if (it is PlainText) {
                    //如果消息这一部分是纯文本
                }
            }
        }
        globalEventChannel().subscribeAlways(
            FriendMessageEvent::class,
            EmptyCoroutineContext,
            Listener.ConcurrencyKind.CONCURRENT
        ) {
            //好友信息
        }
        globalEventChannel().subscribeAlways(
            NewFriendRequestEvent::class,
            EmptyCoroutineContext,
            Listener.ConcurrencyKind.CONCURRENT
        ) {
            //自动同意好友申请
            accept()
        }
        globalEventChannel().subscribeAlways(
            BotInvitedJoinGroupRequestEvent::class,
            EmptyCoroutineContext,
            Listener.ConcurrencyKind.CONCURRENT
        ) {
            //自动同意加群申请
            accept()
        }
    }
}
