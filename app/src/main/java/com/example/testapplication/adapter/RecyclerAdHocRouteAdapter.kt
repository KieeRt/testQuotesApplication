package com.example.testapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R

import com.example.testapplication.model.QuoteList
import org.w3c.dom.Text

class RecyclerAdHocRouteAdapter() : RecyclerView.Adapter<AdHocRoutesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdHocRoutesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ad_hoc_route, parent, false)



        return AdHocRoutesViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: AdHocRoutesViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.quote).text = "prova assegnazione"
        holder.bind()


    }

    override fun getItemCount(): Int = 4
}

class AdHocRoutesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind() {
        var quote  = view.findViewById<TextView>(R.id.quote)
        quote.text = "prova testo"
    }
}