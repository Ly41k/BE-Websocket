package com.life4earth

import com.life4earth.feature.chat.configureChatsRouting
import com.life4earth.feature.message.configureMessageRouting
import com.life4earth.plugins.configureRouting
import com.life4earth.plugins.configureSerialization
import com.life4earth.plugins.configureSockets
import com.life4earth.utils.Constants.BASE_LOCAL_HOST
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = BASE_LOCAL_HOST,
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureRouting()
    configureSerialization()
    configureChatsRouting()
    configureMessageRouting()
}
