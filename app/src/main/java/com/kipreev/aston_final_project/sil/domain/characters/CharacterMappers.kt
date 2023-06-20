package com.kipreev.aston_final_project.domain.characters

import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterInfoUIModel

fun ResultCharactersDto.toUI() =
    CharacterInfoUIModel(
        id = id,
        imageUrl = image,
        name = name,
        status = status,
        species = species,
        gender = gender,
        created = created,
        location = locationDto,
        origin = origin
    )