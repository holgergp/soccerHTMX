package com.grosseplankermann.soccerHTMX

data class LeagueTable(val positions: List<UITeam>)

data class Team(val id: String, val name: String)

data class UITeam(val id: String, val name: String, var editMode: Boolean)

fun toTeam(uiTeam: UITeam): Team = Team(uiTeam.id, uiTeam.name)
fun toUITeam(team: Team): UITeam = UITeam(team.id, team.name, editMode = false)

data class FormData(val team: List<String>)
