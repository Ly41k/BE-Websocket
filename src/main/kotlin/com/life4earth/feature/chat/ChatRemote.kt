package com.life4earth.feature.chat

import kotlinx.serialization.Serializable

@Serializable
data class ChatResponse(
    val chatId: Int,
    val chatName: String
)

fun getMockChats(): List<ChatResponse> {
    return buildList {
        add(ChatResponse(0, "Developers"))
        add(ChatResponse(1, "Customers"))
    }
}
