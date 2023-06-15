package com.kipreev.aston_final_project.data.network.models.episode

data class SingleEpisode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)