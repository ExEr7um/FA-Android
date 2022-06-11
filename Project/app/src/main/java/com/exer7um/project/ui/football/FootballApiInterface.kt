package com.exer7um.project.ui.football

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootballApiInterface {
    @Headers(
        "x-rapidapi-host: https://v3.football.api-sports.io",
        "x-rapidapi-key: ff8795b2f432e6f5a4a7c77ebdd22085"
    )
    @GET("fixtures?league=2&season=2021")
    fun getFootballData(@Query("from") from: String, @Query("to") to: String): Call<FootballData>
}