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

    fun getDatabaseContents() = database

    fun getResortedList(sortableFormData: SortableFormData): LeagueTable = LeagueTable(
        sortableFormData.team.map { id ->
            toUITeam(teams.find { team -> team.id == id }!!)
        }
    )

    fun storeResortedList(sortableFormData: SortableFormData): LeagueTable =
        getResortedList(sortableFormData).also { database = it }

    fun getTeamsInEditMode(teamId: String): LeagueTable = LeagueTable(
        getDatabaseContents().positions.map {
            if (teamId != it.id) {
                it
            } else {
                UITeam(id = teamId, name = it.name, editMode = !it.editMode)
            }
        }
    )

    fun storeEditModedList(teamId: String): LeagueTable =
        getTeamsInEditMode(teamId).also { database = it }

    fun getListWithAdaptedName(formData: SaveSingleTeamFormData): LeagueTable = LeagueTable(
        getDatabaseContents().positions.map {
            if (formData.teamId != it.id) {
                it
            } else {
                UITeam(id = formData.teamId, name = formData.teamName, editMode = false)
            }
        }
    )

    fun storeListWithAdaptedName(saveSingleTeamFormData: SaveSingleTeamFormData): LeagueTable =
        getListWithAdaptedName(saveSingleTeamFormData).also { database = it }
}
