/*
* Name:sample example of kotlin mirai
* author:Eritque arcus
* blog:https://blog.csdn.net/qq_40832960
 */
package com.example.plugin

import net.mamoe.mirai.Bot
import net.mamoe.mirai.console.plugins.PluginBase
import net.mamoe.mirai.event.*
import net.mamoe.mirai.event.events.NewFriendRequestEvent
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.message.MessageEvent

object ExamplePluginMain : PluginBase() {

    override fun onEnable() {
        super.onEnable()
        //插件已加载
        logger.info("Plugin loaded!")

        //在这处理信息
        subscribeMessages {
            //接收全部人信息
            "如果接收的信息是这个" reply{"返回这个"}
            "签到" reply {"Hi ${sender.nick}\n 我们还在维修呢"}
            "复读" reply {"$message"}
        }
        subscribeGroupMessages {
            //处理群消息
            "Hi" reply {"hi ${sender.nick}"}
        }
        subscribeFriendMessages {
            //处理个人信息
            "你好" reply { "hi" }
            "机器人" reply{ "h" }
        }
        subscribeTempMessages {
            //处理临时信息
        }
        subscribeAlways<NewFriendRequestEvent> {
            //自动同意加好友
            this.accept()
        }

    }
}