package com.example.besthack.network

class ApiHelper(private val api: BestHackApi) {

    suspend fun getCities() = api.getCities()
    suspend fun getCityCourse(city: String) = api.getCityCourse(city = city)
}
