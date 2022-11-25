package com.example.tayseer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tayseer.model.*
import kotlinx.android.synthetic.main.listview.view.*

class MyAdapter(val context: Context, val countryList: MutableList<CountryList>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagUrl = itemView.image
        val countryName = itemView.countryName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.countryName.text = countryList[position].payload.result[position].countryName
        Glide.with(context).load(countryList[position].payload.result[position].flagUrl)
            .into(holder.flagUrl)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}