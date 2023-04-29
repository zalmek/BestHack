package com.example.besthack.network

import com.example.besthack.ui.theme.models.City
import com.example.besthack.vm.CitiesUiState
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface BestHackApi {



    @GET("cities")
    suspend fun getCities(): List<City>

    companion object RetrofitBuilder{
        private const val BASE_URL = "https://644d4a6957f12a1d3ddc4d6e.mockapi.io/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: BestHackApi = getRetrofit().create()
    }

}