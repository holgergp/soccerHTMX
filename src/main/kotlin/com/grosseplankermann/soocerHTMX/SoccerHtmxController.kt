package com.grosseplankermann.soocerHTMX

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SoccerHtmxController {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun normalRequest(details: HtmxRequest?): String? {
        return "soccerTable"
    }
}
