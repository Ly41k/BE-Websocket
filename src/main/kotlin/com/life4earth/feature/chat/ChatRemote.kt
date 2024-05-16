package com.life4earth.feature.chat

import kotlinx.serialization.Serializable

@Serializable
data class ChatResponse(
    val chatId: Int,
    val chatName: String,
    val iconUrl: String,
)

fun getMockChats(): List<ChatResponse> {
    return buildList {
        add(ChatResponse(0, "Developers", "https://images.pexels.com/photos/1391498/pexels-photo-1391498.jpeg"))
        add(ChatResponse(1, "Customers", "https://images.pexels.com/photos/1758144/pexels-photo-1758144.jpeg"))
    }
}
