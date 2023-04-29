package com.example.besthack.network

import com.example.besthack.ui.theme.models.City
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttp = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp)
                .build()
        }
        val api: BestHackApi = getRetrofit().create()
    }

}