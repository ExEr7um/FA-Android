package com.exer7um.project.ui.football

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface FootballApiInterface {
    @Headers(
        "x-rapidapi-host: https://v3.football.api-sports.io",
        "x-rapidapi-key: ff8795b2f432e6f5a4a7c77ebdd22085"
    )
    @GET("fixtures?league=235&season=2021&from=2022-04-05&to=2022-04-19")
    fun getFootballData(): Call<FootballData>
}