package com.example.tayseer.api

import com.example.tayseer.model.CountryList
import com.example.tayseer.model.PostPayload
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiIntterface {
    @POST("orm/lookups/getsendingcountries/")
    suspend fun getCountry(@Body payload: PostPayload): Call<CountryList>
}