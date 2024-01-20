package com.example.islamiapp.home.screens.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class HadeethAdapter(val ahadeethList: ArrayList<Hadeeth>) :
    RecyclerView.Adapter<HadeethAdapter.ViewHolder>() {
    var onHadeethClick: OnHadeethClick? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hadeethTv = itemView.findViewById<TextView>(R.id.recyclerViewItemTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.hadeeth_item, parent, false)
        )
    }

    override fun getItemCount(): Int = ahadeethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hadeethTv.text = ahadeethList[position].hadeethTitle
        holder.itemView.setOnClickListener {
            onHadeethClick?.onHadeethClick(ahadeethList[position], position)
        }
    }

    interface OnHadeethClick {
        fun onHadeethClick(hadeeth: Hadeeth, position: Int)
    }
}