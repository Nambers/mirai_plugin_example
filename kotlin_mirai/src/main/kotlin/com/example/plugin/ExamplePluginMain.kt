/*
* Name:sample example of kotlin mirai
* author:Eritque arcus
* blog:https://blog.csdn.net/qq_40832960
 */
package com.example.plugin

import net.mamoe.mirai.console.plugins.PluginBase
import net.mamoe.mirai.event.events.NewFriendRequestEvent
import net.mamoe.mirai.event.subscribeAlways
import net.mamoe.mirai.message.FriendMessageEvent
import net.mamoe.mirai.message.GroupMessageEvent
import net.mamoe.mirai.message.MessageEvent
import net.mamoe.mirai.message.TempMessageEvent

object ExamplePluginMain : PluginBase() {

    override fun onEnable() {
        super.onEnable()
        //插件已加载
        logger.info("Plugin loaded!")

        subscribeAlways<MessageEvent> {
            //全部信息
        }
        subscribeAlways<GroupMessageEvent> {
            //群信息
        }
        subscribeAlways<FriendMessageEvent> {
            //个人信息
            reply("信息")
        }
        subscribeAlways<TempMessageEvent> {
            //临时信息
        }
        subscribeAlways<NewFriendRequestEvent> {
            //自动同意加好友

            this.accept()
        }

    }
}