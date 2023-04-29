package com.example.besthack.network

import android.util.Log
import com.example.besthack.ui.theme.models.City
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
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
            val logging = Interceptor { chain ->
                val request = chain.request()
                lateinit var response: Response
                var responseOK: Boolean = false
                var tryCount: Int = 0

                while (!responseOK && tryCount < 3) {
                    try {
                        response = chain.proceed(request);
                        responseOK = response.isSuccessful;
                    }catch (e: Exception){
                        Log.d("TAG", "Request is not successful - $tryCount");
                    }finally{
                        tryCount++
                    }
                }

                // otherwise just pass the original response on
                response
            }

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