package com.grosseplankermann.soccerHTMX

import org.springframework.stereotype.Repository

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

fun getInitialData(): LeagueTable = LeagueTable(teams.map { toUITeam(it) })

@Repository
class SoccerHtmxRepository(var database: LeagueTable = getInitialData()) {

    val emptyTeam = Team("empty", "empty")

    fun getDatabaseContents() = database

    fun getResortedList(formData: FormData): LeagueTable = LeagueTable(
        formData.team.map { id ->
            toUITeam(teams.find { team -> team.id == id }!!)
        }
    )

    fun storeResortedList(formData: FormData): LeagueTable = getResortedList(formData).also { database = it }

    fun getTeamInEditMode(teamId: String): UITeam =
        toUITeam(teams.find { team -> team.id == teamId }!!).apply { editMode = true }

    fun getTeamsInEditMode(teamId: String): LeagueTable = LeagueTable(
        getDatabaseContents().positions.map {
            if (teamId != it.id) {
                it
            } else {
                it.apply { editMode = true }
            }
        }
    )

    fun storeEditModedList(teamId: String): LeagueTable =
        getTeamsInEditMode(teamId).also { database = it }
}
