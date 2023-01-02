package com.grosseplankermann.soccerHTMX

import io.github.wimdeblauwe.hsbt.mvc.HtmxRequest
import io.github.wimdeblauwe.hsbt.mvc.HxRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SoccerHtmxController(val repository: SoccerHtmxRepository) {
    @GetMapping("/") // Only called on a full page refresh, not an htmx request
    fun indexRequest(model: Model): String? {
        model.addAttribute("soccerTable", repository.getDatabaseContents())
        return "soccerTable"
    }

    @PostMapping("/soccerTable")
    @HxRequest
    fun soccerTable(sortableFormData: SortableFormData, details: HtmxRequest?, model: Model): String? {
        val resortedList = repository.storeResortedList(sortableFormData)
        model.addAttribute("soccerTable", resortedList)
        return "fragments :: soccer-table"
    }

    @PostMapping("/edit/{id}")
    @HxRequest
    fun edit(@PathVariable id: String, details: HtmxRequest?, model: Model): String? {
        val editModedList = repository.storeEditModedList(id)

        model.addAttribute("soccerTable", editModedList)
        return "fragments :: soccer-table"
    }

    @PostMapping("/saveSingleTeam/{id}")
    @HxRequest
    fun saveSingleTeam(
        @PathVariable id: String,
        formData: SaveSingleTeamFormData,
        details: HtmxRequest?,
        model: Model
    ): String? {
        val listWithAdaptedName = repository.storeListWithAdaptedName(formData)

        model.addAttribute("soccerTable", listWithAdaptedName)
        return "fragments :: soccer-table"
    }
}
