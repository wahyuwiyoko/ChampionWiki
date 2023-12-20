package com.wahyuwiyoko.champion.recyclerview.viewholders

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wahyuwiyoko.champion.databinding.ItemRowChampionBinding

class ListVH(binding: ItemRowChampionBinding) : RecyclerView.ViewHolder(binding.root) {
    val tvName: TextView = binding.tvItemName
    val tvSubtitle: TextView = binding.tvItemSubtitle
    val imgAvatar: ImageView = binding.imgItemAvatar
}