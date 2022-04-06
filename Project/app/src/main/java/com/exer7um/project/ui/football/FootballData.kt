package com.exer7um.project.ui.football

data class FootballData(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<FootballResponse>,
    val results: Int
)