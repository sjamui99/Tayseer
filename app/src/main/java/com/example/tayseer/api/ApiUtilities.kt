package com.example.tayseer.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {
    val BASE_URL = "https://devapi.paysii.com/"
    val httpClient = OkHttpClient.Builder().build()
    lateinit var apiInterface: ApiIntterface
    private fun setRetrofit(url: String) {

        val httpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .baseUrl(url).build()

        apiInterface = retrofit.create(ApiIntterface::class.java)
    }

    var apiClient: ApiUtilities? = null


    fun getApi(): ApiIntterface {
        ApiUtilities.setRetrofit(BASE_URL)
        return apiInterface
    }

}