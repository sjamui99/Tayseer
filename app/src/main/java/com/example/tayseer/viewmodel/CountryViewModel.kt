package com.example.tayseer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tayseer.model.*
import com.example.tayseer.repository.CountryRepository

class CountryViewModel() : ViewModel() {
    private val countryRepository: CountryRepository = CountryRepository()

    val country: LiveData<CountryList>
        get() = countryRepository.country

}