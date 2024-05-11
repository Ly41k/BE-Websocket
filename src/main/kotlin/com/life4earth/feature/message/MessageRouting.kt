package com.life4earth.feature.message

import com.life4earth.plugins.Connection
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

fun Application.configureMessageRouting() {
    routing {
        val connections = Collections.synchronizedSet<Connection?>(LinkedHashSet())
        val json = Json { encodeDefaults = true }

        webSocket("/message") {
            val thisConnection = Connection(this)
            connections += thisConnection
            try {
                while (true) {
                    val message = receiveDeserialized<MessageReceive>()
                    val response = message.toMessageResponse()
                    val responseJsonString = json.encodeToString(response)
                    connections.forEach { it.session.send(responseJsonString) }
                }
            } catch (e: Exception) {
                println(e.localizedMessage)
            } finally {
                println("Removing $thisConnection!")
                connections -= thisConnection
            }
        }
    }
}
