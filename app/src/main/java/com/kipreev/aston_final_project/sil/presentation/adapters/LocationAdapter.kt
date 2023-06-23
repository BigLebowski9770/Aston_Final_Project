package com.kipreev.aston_final_project.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.LocationItemBinding
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem

class LocationAdapter(private val listener: RVClickItem) : ListAdapter<ResultLocationDto, LocationAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = LocationItemBinding.bind(view)

        fun bind(location: ResultLocationDto, listener: RVClickItem) = with(binding) {
            locationName.text = location.name
            locationType.text = location.type
            locationDimension.text = location.dimension
            locationId.text = location.id.toString()

            itemView.setOnClickListener {
                listener.onLocationItemClick(location)
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<ResultLocationDto>() {
        override fun areItemsTheSame(oldItem: ResultLocationDto, newItem: ResultLocationDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultLocationDto, newItem: ResultLocationDto): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.location_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}