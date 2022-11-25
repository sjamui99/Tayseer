package com.example.tayseer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Result(
    val countryCode: String,
    @PrimaryKey(autoGenerate = true)
    val countryId: Int,
    val countryName: String,
    val currencies: List<Any>,
    val flagUrl: String,
    val mobileMaxLength: Int,
    val mobileMinLength: Int,
    val payingCountries: List<Any>,
    val sendingCountryCallingCode: String
)