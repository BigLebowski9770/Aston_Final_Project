package com.kipreev.aston_final_project.sil.domain.locations

import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.sil.presentation.fragments.locations.LocationInfoUIModel

fun ResultLocationDto.toUI() =
    LocationInfoUIModel(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        created = created
    )