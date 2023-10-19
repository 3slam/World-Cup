package com.example.worldcup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.data.domain.MusicItem
import com.example.worldcup.R
import com.bumptech.glide.Glide

class MusicAdapter(private val musicList: List<MusicItem>) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.music_title)
        val imageView: ImageView = itemView.findViewById(R.id.music_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent, false)
        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentItem = musicList[position]
        holder.titleView.text = currentItem.title
        // Load image from URL into imageView
        Glide.with(holder.itemView.context)
            .load(currentItem.image)
            .into(holder.imageView)
    }

    override fun getItemCount() = musicList.size
}