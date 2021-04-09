package josh.brawl

import dev.fritz2.dom.html.render
import josh.brawl.view.App

suspend fun main() = render("#root") {
  App()
}
