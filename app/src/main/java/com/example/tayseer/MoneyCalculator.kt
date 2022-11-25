package com.example.tayseer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_money_calculator.*

class MoneyCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money_calculator)

        val spinner: Spinner = purpose_list
        ArrayAdapter.createFromResource(
            this,
            R.array.purposes,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }

    }

}