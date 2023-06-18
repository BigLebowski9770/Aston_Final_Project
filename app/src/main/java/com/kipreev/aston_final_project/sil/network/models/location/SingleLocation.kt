package com.kipreev.aston_final_project.data.network.models.location

data class SingleLocation(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)