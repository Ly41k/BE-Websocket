package com.life4earth.feature.chat

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureChatsRouting() {
    routing {
        get("/chats") {
            val chatsController = ChatController(call)
            chatsController.getChats()
        }
    }
}
