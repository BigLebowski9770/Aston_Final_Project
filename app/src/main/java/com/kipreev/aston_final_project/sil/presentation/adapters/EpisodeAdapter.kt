package com.kipreev.aston_final_project.sil.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.EpisodesItemBinding
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem

class EpisodeAdapter(private val listener: RVClickItem) :
    ListAdapter<ResultEpisodeDto, EpisodeAdapter.Holder>(
        Comparator()
    ) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = EpisodesItemBinding.bind(view)

        fun bind(episode: ResultEpisodeDto, listener: RVClickItem) = with(binding) {
            episodeName.text = episode.name
            episodeAirDate.text = episode.air_date
            episodeCode.text = episode.episode
            episodeId.text = episode.id.toString()

            itemView.setOnClickListener {
                listener.onEpisodeItemClick(episode)
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<ResultEpisodeDto>() {
        override fun areItemsTheSame(
            oldItem: ResultEpisodeDto,
            newItem: ResultEpisodeDto
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResultEpisodeDto,
            newItem: ResultEpisodeDto
        ): Boolean {
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