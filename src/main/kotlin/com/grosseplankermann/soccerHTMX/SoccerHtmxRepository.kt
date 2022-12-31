package com.grosseplankermann.soccerHTMX

import org.springframework.stereotype.Repository

@Repository
class SoccerHtmxRepository {
    val emptyTeam = Team("empty", "empty")
    val teams = listOf(
        Team("BMG", "Borussia Mönchengladbach"),
        Team("FCB", "Bayern München"),
        Team("BVB", "Borussia Dortmund"),
        Team("SCF", "SC Freiburg"),
        Team("RBL", "Red Bull Leipzig"),
        Team("EFR", "Eintracht Frankfurt"),
        Team("EU", "Union Berlin"),
        Team("VFW", "VFL Wolfsburg"),
        Team("SVW", "Werder Bremen"),
        Team("M05", "Mainz 05"),
        Team("TSG", "TSG Hoffenheim"),
        Team("B04", "Bayer Leverkusen"),
        Team("1FC", "1.FC Köln"),
        Team("B04", "Bayer Leverkusen"),
        Team("FCA", "FC Augsburg"),
        Team("VFB", "VFB Stuttgart"),
        Team("VFL", "VFL Bochum"),
        Team("S04", "Schalke 04")
    )

    fun getInitialData(): LeagueTable {
        return LeagueTable(teams)
    }

    fun getResortedList(formData: FormData): LeagueTable = LeagueTable(
        formData.team.map { id ->
            teams.find { team -> team.id == id }!!
        }
    )
}
