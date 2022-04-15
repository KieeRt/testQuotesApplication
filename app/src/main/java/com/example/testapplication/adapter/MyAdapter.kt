package com.example.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.model.Result

class MyAdapter(val context: Context, private val list: List<Result>, val listener: View.OnClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View, private val list: List<Result>) : RecyclerView.ViewHolder(itemView) {
        // sto dentro una riga e recupero il riferimento ad ogni singolo elemento

        private var nameAuthor = itemView.findViewById<TextView>(R.id.nameAuthor2)
        private var quote: TextView = itemView.findViewById<TextView>(R.id.quote2)
        private var tags: TextView = itemView.findViewById<TextView>(R.id.tags)
        private var icon_item: ImageView = itemView.findViewById<ImageView>(R.id.icon_item)
        private var data_publish: TextView = itemView.findViewById<TextView>(R.id.data_publish)
        fun bind(position: Int) {
            itemView.setBackgroundColor(R.color.purple_700.toInt())
            nameAuthor.text = list[position].author
            quote.text = list[position].content
            tags.text = list[position].tags.joinToString(separator = " ") { "#$it" }
            data_publish.text = list[position].dateAdded
            icon_item.setOnClickListener(View.OnClickListener {
                if (icon_item.colorFilter == null) {

                    icon_item.setColorFilter(R.color.red)
                }else{
                    icon_item.setColorFilter(null)
                }
                list[position].print()

            })
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // primo passaggio prendo il riferimento all'intera riga
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_ad_hoc_round2, parent, false)
        return MyViewHolder(view, list)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Adesso ho il numero della i-esima riga e ho la possibilità di fare la distinzione
        // di assegnazione per ogni riga. Il riferimento ancora rispetto ogni singola riga

        holder.bind(position)
      //  holder.icon_item.setImageResource(R.drawable.ic_baseline_favorite_24)




    }

    override fun getItemCount(): Int {
        println("numero of item ${list.size}")
        return list.size
    }
}