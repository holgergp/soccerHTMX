package com.grosseplankermann.soccerHTMX

data class LeagueTable(val positions: List<UITeam>)

data class Team(val id: String, val name: String)

data class UITeam(val id: String, val name: String, val editMode: Boolean)

fun toTeam(uiTeam: UITeam): Team = Team(uiTeam.id, uiTeam.name)
fun toUITeam(team: Team): UITeam = UITeam(team.id, team.name, editMode = false)

data class SortableFormData(val team: List<String>)
data class SaveSingleTeamFormData(val teamId: String, val teamName: String)
