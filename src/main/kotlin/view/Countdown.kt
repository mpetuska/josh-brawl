package josh.brawl.view

import dev.fritz2.binding.storeOf
import dev.fritz2.dom.html.RenderContext
import io.ktor.util.date.GMTDate
import kotlinx.browser.window
import kotlin.time.DurationUnit
import kotlin.time.toDuration

private fun GMTDate.durationFromNow() = (timestamp - GMTDate().timestamp).toDuration(DurationUnit.MILLISECONDS)

fun RenderContext.Countdown(to: GMTDate) {
  val duration = storeOf((to.timestamp - GMTDate().timestamp).toDuration(DurationUnit.MILLISECONDS))
  window.setInterval(timeout = 1000, handler = {
    duration.update(to.durationFromNow())
  })
  
  duration.data.renderElement {
    h1 {
      +it.toComponents { days, hours, minutes, seconds, _ ->
        "$days day${if (days == 1) "" else "s"} " +
            "$hours hour${if (hours == 1) "" else "s"} " +
            "$minutes minute${if (minutes == 1) "" else "s"} " +
            "$seconds second${if (seconds == 1) "" else "s"}"
      }
    }
  }
}
