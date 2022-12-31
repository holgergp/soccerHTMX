package com.grosseplankermann.soccerHTMX

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SoccerHtmxController {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun indexRequest(details: HtmxRequest?): String? {
        return "soccerTable"
    }

    @GetMapping("/linkClicked")
    @HxRequest
    fun clickRequest(details: HtmxRequest?): String? {
        return "fragments :: test-fragment"
    }
}
