package com.example.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.model.Result

class RecyclerQuoteListNoSaveAdapter(val context: Context, private val list: List<Result>): RecyclerView.Adapter<RecyclerQuoteListNoSaveAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View, private val list: List<Result>) : RecyclerView.ViewHolder(itemView) {
        private var nameAuthor = itemView.findViewById<TextView>(R.id.nameAuthor2)
        private var quote: TextView = itemView.findViewById<TextView>(R.id.quote2)
        private var tags: TextView = itemView.findViewById<TextView>(R.id.tags)
        private var data_publish: TextView = itemView.findViewById<TextView>(R.id.data_publish)
        private var icon: ImageView = itemView.findViewById<ImageView>(R.id.icon_item)

        fun bind(position: Int) {
            setStyle()
            setData(position)
            setObserver(position)
        }

        private fun setStyle(){
            // force to remove icon of hearth from the view
            icon.isInvisible = true
            icon.isClickable = false
            itemView.setBackgroundColor(R.color.purple_700.toInt())
        }

        private fun setData(position: Int){
            nameAuthor.text = list[position].author
            quote.text = list[position].content
            tags.text = list[position].tags.joinToString(separator = " ") { "#$it" }
            data_publish.text = list[position].dateAdded
        }

        private fun setObserver(position: Int) {
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_ad_hoc_round2, parent, false)
        return MyViewHolder(view, list)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}