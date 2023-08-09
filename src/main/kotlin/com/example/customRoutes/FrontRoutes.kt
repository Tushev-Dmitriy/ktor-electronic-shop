package com.example.customRoutes

import com.example.repository.Repo
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import freemarker.cache.*
import freemarker.core.*
import io.ktor.server.freemarker.*

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates/front")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
}

fun Route.frontRoutes(
    db: Repo
) {
    get ("/test"){
        call.respond(FreeMarkerContent("test.html", mapOf("product" to db.getAllProducts())))
    }
}