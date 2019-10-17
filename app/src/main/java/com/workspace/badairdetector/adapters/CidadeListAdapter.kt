package com.workspace.badairdetector.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.workspace.badairdetector.R
import com.workspace.badairdetector.models.Aqi

class CidadeListAdapter (private val aqi : Aqi) : RecyclerView.Adapter<CidadeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CidadeViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_cidade, parent, false)
        return CidadeViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return aqi.data.size
    }

    override fun onBindViewHolder(holder: CidadeViewHolder, position: Int) {

        holder.aqiItem.text = aqi.data[position].aqi.toString()
        holder.idxItem.text = aqi.data[position].idx.toString()
     //   holder.cityItem.text = aqi.data[position].city.toString()

    }
}

class CidadeViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    val aqiItem : TextView = itemView.findViewById(R.id.item_aqi)
    val idxItem : TextView = itemView.findViewById(R.id.item_idx)
  //  val cityItem : TextView = itemView.findViewById(R.id.item_city)
}
