package com.kipreev.aston_final_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.CharacterItemBinding

class CharAdapter :
    ListAdapter<com.kipreev.aston_final_project.elem.models.Result,
            CharAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CharacterItemBinding.bind(view)
        fun bind(character: com.kipreev.aston_final_project.elem.models.Result) = with(binding) {
            charImage.load(character.image)
            charName.text = character.name
            charSpecies.text = character.species
            charStatus.text = character.status
            charGender.text = character.gender
            charCreated.text = character.created
            charId.text = character.id.toString()
        }
    }

    class Comparator
        : DiffUtil.ItemCallback<com.kipreev.aston_final_project.elem.models.Result>() {
        override fun areItemsTheSame(
            oldItem: com.kipreev.aston_final_project.elem.models.Result,
            newItem: com.kipreev.aston_final_project.elem.models.Result
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: com.kipreev.aston_final_project.elem.models.Result,
            newItem: com.kipreev.aston_final_project.elem.models.Result
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}
