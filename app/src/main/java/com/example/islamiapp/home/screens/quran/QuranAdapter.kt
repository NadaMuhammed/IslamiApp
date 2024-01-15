package com.example.islamiapp.home.screens.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class QuranAdapter(val quranList: ArrayList<Quran>) :
    RecyclerView.Adapter<QuranAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val suraTv = itemView.findViewById<TextView>(R.id.suraTv)
        val ayatTv = itemView.findViewById<TextView>(R.id.ayatTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.quran_item, parent, false)
        )
    }

    override fun getItemCount(): Int = quranList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraTv.text = quranList[position].suraName
        holder.ayatTv.text = quranList[position].ayatNumber.toString()
    }
}