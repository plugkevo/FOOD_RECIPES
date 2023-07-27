package com.example.foodrecipes.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.foodrecipes.R
import com.example.foodrecipes.model.ModelMain


class MainAdapter(private val mContext: Context, private val items: List<ModelMain>, private val onSelectData: onSelectedData) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface onSelectedData {
        fun onSelected(modelMain: ModelMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_category, parent ,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
       val data = items[position]

        //get image
        Glide.with(mContext)
            .load(data.strCategoryThumb)
            .placeholder(R.drawable.ic_food_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imgKategori)

        holder.tvKategori.text =data.strCategory
        holder.cvKategori.setOnClickListener {
            onSelectData.onSelected(data)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


    //class holder
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val tvKategori: TextView = itemView.findViewById(R.id.tvKategori)
        val cvKategori: CardView = itemView.findViewById(R.id.cvKategori)
        val imgKategori: ImageView = itemView.findViewById(R.id.imgKategori)
    }
}