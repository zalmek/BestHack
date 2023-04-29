package com.example.besthack.network

class ApiHelper(private val api: BestHackApi) {

    suspend fun getCities() = api.getCities()
}
