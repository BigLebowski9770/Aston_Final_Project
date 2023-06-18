package com.kipreev.aston_final_project.domain.characters

import com.kipreev.aston_final_project.data.network.models.character.CharacterInfoResponse
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterInfoUIModel

fun CharacterInfoResponse.toUI() =
    CharacterInfoUIModel(
        id = id,
        imageUrl = image,
        name = name,
        status = status,
        species = species,
        gender = gender,
        created = created
    )