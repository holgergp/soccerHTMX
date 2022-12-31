package com.grosseplankermann.soccerHTMX

data class LeagueTable(val positions: List<Team>)

data class Team(val id: String, val name: String)

fun getInitialData(): LeagueTable =
    LeagueTable(listOf(Team("BMG", "Borussia Mönchengladbach"), Team("FCB", "Bayern München")))
