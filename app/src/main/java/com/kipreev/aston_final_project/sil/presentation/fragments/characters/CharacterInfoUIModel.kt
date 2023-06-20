package com.kipreev.aston_final_project.sil.presentation.fragments.characters

import com.kipreev.aston_final_project.data.network.models.chars.CharacterOriginResponse
import com.kipreev.aston_final_project.data.network.models.chars.LocationResponseDto

data class CharacterInfoUIModel(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val created: String,
    val location: LocationResponseDto,
    val origin: CharacterOriginResponse
)
