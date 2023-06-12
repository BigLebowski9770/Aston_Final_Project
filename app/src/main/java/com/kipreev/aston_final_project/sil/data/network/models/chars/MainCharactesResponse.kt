package com.kipreev.aston_final_project.data.network.models.chars

data class MainCharactesResponse(
    val info: CharactersInfoResponse,
    val results: List<ResultCharactersDto>
)
