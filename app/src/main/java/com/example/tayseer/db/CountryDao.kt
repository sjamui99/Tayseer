package com.example.tayseer.db

import androidx.room.Insert
import androidx.room.Query
import com.example.tayseer.model.*
interface CountryDao {

    @Insert
    suspend fun addCountry(countries:List<Result>)

    @Query("SELECT * FROM countries")
    suspend fun getCountry():List<Result>
}