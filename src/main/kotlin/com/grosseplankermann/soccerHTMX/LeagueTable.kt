package com.grosseplankermann.soccerHTMX

data class LeagueTable(val positions: List<Team>)

data class Team(val id: String, val name: String)

data class FormData(val team: List<String>)
