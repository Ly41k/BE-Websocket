package com.life4earth.feature.chat

import io.ktor.server.application.*
import io.ktor.server.response.*

class ChatController(private val call: ApplicationCall) {
    suspend fun getChats() {
        println("getChats - $call")
        call.respond(getMockChats())
    }
}
