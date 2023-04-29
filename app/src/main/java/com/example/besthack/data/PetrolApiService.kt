package com.example.besthack.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PetrolApiService {

    @GET("cities")
    suspend fun getCodeSearch(
        @Query("city") city: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
    ): Response<String>
}