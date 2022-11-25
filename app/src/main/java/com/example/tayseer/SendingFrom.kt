package com.example.tayseer


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tayseer.viewmodel.CountryViewModel
import com.example.tayseer.model.*
import kotlinx.android.synthetic.main.activity_sending_from.*


class SendingFrom : AppCompatActivity() {
    private lateinit var countryViewModel: CountryViewModel
    private var countryList = mutableListOf<CountryList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sending_from)
        val adapter = MyAdapter(this@SendingFrom, countryList)
        recyclerViewF.adapter = adapter
        recyclerViewF.layoutManager = LinearLayoutManager(this)
//        supportActionBar!!.title = "Sending From"
//        actionBar!!.title.toString()
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        countryViewModel = CountryViewModel()
        countryViewModel.country.observe(this) {
            it.payload.result.iterator().forEach { country ->
//                Log.d("Suleman", "name:${it.payload.result.size} ")
                adapter.countryList.clear()
//                adapter.countryList.addAll(it.payload.result)
                adapter.notifyDataSetChanged()


            }
        }


        submitFrom.setOnClickListener {
            val intent = Intent(this, SendingTo::class.java)
            startActivity(intent)
        }


    }


}