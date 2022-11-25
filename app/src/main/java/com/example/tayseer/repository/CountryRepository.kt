package com.example.tayseer.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tayseer.api.ApiIntterface
import com.example.tayseer.api.ApiUtilities
import com.example.tayseer.model.CountryList
import com.example.tayseer.model.PostPayload
import com.example.tayseer.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository {
    private val countryLiveData = MutableLiveData<CountryList>()

    val country: LiveData<CountryList>
        get() = countryLiveData


    suspend fun getCountries() {

        ApiUtilities.getApi().getCountry(PostPayload()).enqueue(object : Callback<CountryList> {
            override fun onResponse(call: Call<CountryList>, response: Response<CountryList>) {
                if (response.isSuccessful) {

                    Log.d("Suleman", "onResponse: ${response.body()?.payload?.result?.size}")
                }
            }

            override fun onFailure(call: Call<CountryList>, t: Throwable) {
                Log.d("Suleman", "onFailure: ${t.message}")
            }

        })
    }
}