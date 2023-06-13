package com.kipreev.aston_final_project.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.EpisodesItemBinding
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisode
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocation
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem

class EpisodeAdapter(val listener: RVClickItem): ListAdapter<ResultEpisode, EpisodeAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = EpisodesItemBinding.bind(view)

        fun bind(episode: ResultEpisode, listener: RVClickItem) = with(binding) {
            episodeName.text = episode.name
            episodeAirDate.text = episode.air_date
            episodeCode.text = episode.episode
            episodeId.text = episode.id.toString()

            itemView.setOnClickListener {
                listener.onEpisodeItemClick(episode)
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<ResultEpisode>() {
        override fun areItemsTheSame(oldItem: ResultEpisode, newItem: ResultEpisode): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultEpisode, newItem: ResultEpisode): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.episodes_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}