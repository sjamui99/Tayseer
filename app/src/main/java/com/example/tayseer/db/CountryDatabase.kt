package com.example.tayseer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tayseer.api.ApiIntterface
import com.example.tayseer.api.ApiUtilities
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Database(entities = [Result::class], version = 1)
abstract class CountryDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        fun getDatabase(context: Context): CountryDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, CountryDatabase::class.java, "countryDB")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}