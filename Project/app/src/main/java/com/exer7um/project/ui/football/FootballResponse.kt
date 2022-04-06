package com.exer7um.project.ui.football

data class FootballResponse(
    val fixture: Fixture,
    val goals: Goals,
    val league: League,
    val score: Score,
    val teams: Teams
)