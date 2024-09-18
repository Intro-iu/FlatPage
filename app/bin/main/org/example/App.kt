package org.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.http.*
import com.sksamuel.hoplite.ConfigLoader
import java.io.File

data class GereralConfig(
    val Title: String,
    val Timezone: String
)

data class Item(
    val itemName: String,
    val itemIcon: String,
    val itemLink: String
)

data class Category(
    val categoryName: String,
    val items: List<Item>
)

data class Config(
    val Gereral: GereralConfig,
    val Category: List<Category>
)

fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                val iconContent = File("src/main/resources/icon.html").readText()
                val config = ConfigLoader().loadConfigOrThrow<Config>("src/main/resources/config.toml")
                val dynamicHtmlContent_Category = generateHtml(config)
                val template = File("src/main/resources/template.html").readText()
                val fullHtml = template.replace("{{iconContent}}", iconContent).replace("{{Title}}", config.Gereral.Title).replace("{{Category}}", dynamicHtmlContent_Category)
                call.respondText(fullHtml, ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}

fun generateHtml(config: Config): String {
    val sb = StringBuilder()

    config.Category.forEach { category ->
        sb.appendLine("<div>")
        sb.appendLine("<h2 class=\"section-title\">${category.categoryName}</h2>")
        sb.appendLine("<div class=\"nav\">")

        category.items.forEach { item ->
            sb.appendLine(
                """<a href="${item.itemLink}">
                <svg width="20" height="20"><use xlink:href="#${item.itemIcon}"></use></svg>
                ${item.itemName}
            </a>""".trimIndent()
            )
        }

        sb.appendLine("</div>")
        sb.appendLine("</div>")
    }

    return sb.toString()
}
