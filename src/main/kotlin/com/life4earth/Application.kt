package com.life4earth

import com.life4earth.feature.chat.configureChatsRouting
import com.life4earth.plugins.configureRouting
import com.life4earth.plugins.configureSerialization
import com.life4earth.plugins.configureSockets
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "192.168.1.120",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureRouting()
    configureSerialization()
    configureChatsRouting()
}
