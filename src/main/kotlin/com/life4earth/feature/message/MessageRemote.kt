package com.life4earth.feature.message

import kotlinx.serialization.Serializable

@Serializable
data class MessageReceive(
    val userId: String,
    val chatId: Int,
    val chatName: String,
    val message: String
)

@Serializable
data class MessageResponse(
    val userId: String,
    val chatId: Int,
    val chatName: String,
    val message: String
)

fun MessageReceive.toMessageResponse(): MessageResponse {
    return MessageResponse(
        userId = userId,
        chatId = chatId,
        chatName = chatName,
        message = message
    )
}
