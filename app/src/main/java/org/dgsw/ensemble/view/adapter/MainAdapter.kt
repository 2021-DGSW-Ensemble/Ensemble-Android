package org.dgsw.ensemble.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.dgsw.ensemble.databinding.ItemListBinding
import org.dgsw.ensemble.model.model.VideoData

class VideoAdapter(
    private val videoDataList: List<VideoData>
) : ListAdapter<VideoData, VideoAdapter.VideoViewHolder>(VideoDiffCallback) {

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(view)
    }

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = getItem(position)
        holder.bind(video)
    }

    override fun getItem(position: Int): VideoData {
        return videoDataList[position]
    }

    override fun getItemCount(): Int {
        return videoDataList.size
    }

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
    class VideoViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /* Bind video name and data. */
        fun bind(video: VideoData) {
            this.binding.model = video;
        }
    }
}
object VideoDiffCallback : DiffUtil.ItemCallback<VideoData>() {
    override fun areItemsTheSame(oldItem: VideoData, newItem: VideoData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: VideoData, newItem: VideoData): Boolean {
        return oldItem.id == newItem.id
    }
}