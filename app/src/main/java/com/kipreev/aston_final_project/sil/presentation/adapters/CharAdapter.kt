package com.kipreev.aston_final_project.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.CharacterItemBinding
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem

class CharAdapter(private val listener: RVClickItem) :
    ListAdapter<ResultCharactersDto,
            CharAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = CharacterItemBinding.bind(view)
        fun bind(character: ResultCharactersDto, listener: RVClickItem) = with(binding) {
            charImage.load(character.image)
            charName.text = character.name
            charSpecies.text = character.species
            charStatus.text = character.status
            charGender.text = character.gender
            charCreated.text = character.created
            charId.text = character.id.toString()

            itemView.setOnClickListener {
                listener.onCharItemClick(character)
            }
        }
    }

    class Comparator
        : DiffUtil.ItemCallback<ResultCharactersDto>() {
        override fun areItemsTheSame(
            oldItem: ResultCharactersDto,
            newItem: ResultCharactersDto
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: ResultCharactersDto,
            newItem: ResultCharactersDto
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), listener)
    }

}
