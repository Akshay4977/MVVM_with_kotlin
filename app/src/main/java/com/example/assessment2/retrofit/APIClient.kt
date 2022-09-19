package com.example.assessment2.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient : APIInterface {
    private const val base_url = "https://my-json-server.typicode.com/iranjith4/ad-assignment/"
    private var retrofit: Retrofit? = null
    val retrofitClient: Retrofit?
        get() {
            val httpClient = OkHttpClient.Builder()
            val gson = GsonBuilder()
                .setLenient()
                .create()
            if (retrofit == null) {
                retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(
                        base_url
                    ).client(httpClient.build()).build()
            }
            return retrofit
        }
}