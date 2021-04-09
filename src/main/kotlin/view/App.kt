package josh.brawl.view

import dev.fritz2.components.lineUp
import dev.fritz2.components.stackUp
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.staticStyle
import io.ktor.util.date.GMTDate
import io.ktor.util.date.Month

fun RenderContext.App() {
  
  staticStyle(
    """
    /* width */
    ::-webkit-scrollbar {
      width: 0.75rem;
    }

    /* Track */
    ::-webkit-scrollbar-track {
      box-shadow: inset 0 0 5px grey;
      border-radius: 0.75rem;
    }
    
    /* Handle */
    ::-webkit-scrollbar-thumb {
      background: lightgray;
      box-shadow: inset 0 0 5px grey;
      border-radius: 0.75rem;
    }

    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
      background: gray;
    }
    """.trimIndent()
  )
  
  stackUp({
    css("align-self: center")
    height { "100%" }
    width { "100%" }
    position { relative {} }
    alignItems { center }
  }) {
    items {
      h1 { +"Josh Brawl Countdown" }
      Countdown(
        GMTDate(
          year = 2021,
          month = Month.APRIL,
          dayOfMonth = 24,
          hours = 0,
          minutes = 0,
          seconds = 0
        )
      )
      lineUp {
        items {
          img {
            height(600)
            src("/proof.jpg")
          }
          iframe {
            allowFullscreen(true)
            height("600")
            width("600")
            attr("style", "border:0")
            attr("loading", "lazy")
            src("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3019.2563490983475!2d-96.80038888432033!3d40.82233263879466!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDDCsDQ5JzIwLjQiTiA5NsKwNDcnNTMuNSJX!5e0!3m2!1sen!2suk!4v1617993085275!5m2!1sen!2suk")
          }
        }
      }
    }
  }
}
