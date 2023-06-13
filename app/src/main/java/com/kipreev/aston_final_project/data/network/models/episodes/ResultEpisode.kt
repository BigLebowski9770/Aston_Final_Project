package com.kipreev.aston_final_project.data.network.models.episodes

data class ResultEpisode(
    val air_date: String,
    val character: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)