package com.wahyuwiyoko.champion.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wahyuwiyoko.champion.databinding.ItemRowChampionBinding
import com.wahyuwiyoko.champion.models.Champion

class ListChampionAdapter(
    private val listChampion: ArrayList<Champion>
) : RecyclerView.Adapter<ListChampionAdapter.ListViewHolder>() {
    class ListViewHolder(binding: ItemRowChampionBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvName: TextView = binding.tvItemName
        val tvSubtitle: TextView = binding.tvItemSubtitle
        val imgAvatar: ImageView = binding.imgItemAvatar
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowChampionBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listChampion.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, subtitle, avatar) = listChampion[position]
        holder.tvName.text = name
        holder.tvSubtitle.text = subtitle
        holder.imgAvatar.setImageResource(avatar)
    }
}