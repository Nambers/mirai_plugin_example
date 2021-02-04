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
import net.mamoe.mirai.message.data.Image.Key.queryUrl
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
        name = "插件示例",
        version = "0.1.0"
    )
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }
        //配置文件目录 "${dataFolder.absolutePath}/"

        globalEventChannel().subscribeAlways<GroupMessageEvent>{
            //群消息
            //复读示例
            if (message.contentToString().startsWith("复读")) {
                group.sendMessage(message.contentToString().replace("复读", ""))
            }
            if (message.contentToString() == "hi") {
                //群内发送
                group.sendMessage("hi")
                //向发送者私聊发送消息
                sender.sendMessage("hi")
                //不继续处理
                return@subscribeAlways
            }
            //分类示例
            message.forEach {
                //循环每个元素在消息里
                if (it is Image) {
                    //如果消息这一部分是图片
                    val url = it.queryUrl()
                    group.sendMessage("图片，下载地址$url")
                }
                if (it is PlainText) {
                    //如果消息这一部分是纯文本
                    group.sendMessage("纯文本，内容:${it.content}")
                }
            }
        }
        globalEventChannel().subscribeAlways<FriendMessageEvent>{
            //好友信息
            sender.sendMessage("hi")
        }
        globalEventChannel().subscribeAlways<NewFriendRequestEvent>{
            //自动同意好友申请
            accept()
        }
        globalEventChannel().subscribeAlways<BotInvitedJoinGroupRequestEvent>{
            //自动同意加群申请
            accept()
        }
    }
}
