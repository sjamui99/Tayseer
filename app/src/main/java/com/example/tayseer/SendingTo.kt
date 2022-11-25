package com.example.tayseer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tayseer.model.CountryList
import com.example.tayseer.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.activity_sending_from.*
import kotlinx.android.synthetic.main.activity_sending_to.*

class SendingTo : AppCompatActivity() {
    private lateinit var countryViewModel: CountryViewModel
    private var countryList = mutableListOf<CountryList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sending_to)
        val adapter = MyAdapter(this@SendingTo, countryList)
        recyclerViewT.adapter = adapter
        recyclerViewT.layoutManager = LinearLayoutManager(this)
//    supportActionBar!!.title = "Sending To"
//    actionBar!!.title.toString()
//    supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        countryViewModel = CountryViewModel()
        countryViewModel.country.observe(this) {
            it.payload.result.iterator().forEach { country ->
//                Log.d("Suleman", "name:${it.payload.result.size} ")
                adapter.countryList.clear()
//                adapter.countryList.addAll(it.payload.result)
                adapter.notifyDataSetChanged()


            }
        }
        submitTo.setOnClickListener {
            val intent = Intent(this, MoneyCalculator::class.java)
            startActivity(intent)
        }
    }


}