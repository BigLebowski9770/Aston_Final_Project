package com.kipreev.aston_final_project.data.network.models.locations

data class MainLocationResponse(
    val info: InfoLocationResponse,
    val results: List<ResultLocationDto>
)