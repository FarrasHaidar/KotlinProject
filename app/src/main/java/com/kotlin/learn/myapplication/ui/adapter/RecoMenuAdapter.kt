package com.kotlin.learn.myapplication.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.learn.myapplication.R
import com.kotlin.learn.myapplication.data.model.Menu
import com.kotlin.learn.myapplication.ui.detail.DetailMenuFragment
import com.kotlin.learn.myapplication.ui.member.RecommendationMenuFragment

class RecoMenuAdapter(private val data: ArrayList<Menu>) :
    RecyclerView.Adapter<RecoMenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = data[position]
        holder.imgPhoto.setImageResource(menu.gambarMenu)
        holder.tvName.text = menu.namaMenu
        holder.tvHarga.text = menu.hargaMenu

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMenuFragment::class.java)
            intentDetail.putExtra("KEY", menu)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvHarga: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}

