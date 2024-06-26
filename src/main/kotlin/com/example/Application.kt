package com.example

import com.example.customRoutes.configureTemplating
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.repository.DatabaseFactory
import com.zaxxer.hikari.HikariConfig
import io.ktor.server.config.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    DatabaseFactory.init()

    configureSecurity()
    configureSerialization()
    configureRouting()
    configureTemplating()
}
