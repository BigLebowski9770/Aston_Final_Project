package com.kipreev.aston_final_project.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.LocationItemBinding
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocation
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem

class LocationAdapter(val listener: RVClickItem) : ListAdapter<ResultLocation, LocationAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = LocationItemBinding.bind(view)

        fun bind(location: ResultLocation, listener: RVClickItem) = with(binding) {
            locationName.text = location.name
            locationType.text = location.type
            locationDimension.text = location.dimension
            locationId.text = location.id.toString()

            itemView.setOnClickListener {
                listener.onLocationItemClick(location)
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<ResultLocation>() {
        override fun areItemsTheSame(oldItem: ResultLocation, newItem: ResultLocation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultLocation, newItem: ResultLocation): Boolean {
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