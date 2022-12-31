package com.grosseplankermann.soccerHTMX

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SoccerHtmxController(val repository: SoccerHtmxRepository) {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun indexRequest(model: Model): String? {
        model.addAttribute("soccerTable", repository.getInitialData())
        return "soccerTable"
    }

    @PostMapping("/soccerTable")
    @HxRequest
    fun soccerTable(formData: FormData, details: HtmxRequest?, model: Model): String? {
        model.addAttribute("soccerTable", repository.getResortedList(formData))
        return "fragments :: soccer-table"
    }
}
