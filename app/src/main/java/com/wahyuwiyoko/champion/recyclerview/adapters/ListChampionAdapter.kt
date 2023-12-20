package com.wahyuwiyoko.champion.recyclerview.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahyuwiyoko.champion.activities.DetailActivity
import com.wahyuwiyoko.champion.databinding.ItemRowChampionBinding
import com.wahyuwiyoko.champion.models.Champion
import com.wahyuwiyoko.champion.recyclerview.viewholders.ListVH

class ListChampionAdapter(
    private val listChampion: ArrayList<Champion>
) : RecyclerView.Adapter<ListVH>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListVH {
        val binding = ItemRowChampionBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ListVH(binding)
    }

    override fun getItemCount(): Int = listChampion.size

    override fun onBindViewHolder(holder: ListVH, position: Int) {
        val (name, subtitle, avatar) = listChampion[position]
        holder.tvName.text = name
        holder.tvSubtitle.text = subtitle
        holder.imgAvatar.setImageResource(avatar)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)

            intentDetail.putExtra(
                DetailActivity.EXTRA_CHAMPION, listChampion[holder.adapterPosition]
            )

            holder.itemView.context.startActivity(intentDetail)
        }
    }
}