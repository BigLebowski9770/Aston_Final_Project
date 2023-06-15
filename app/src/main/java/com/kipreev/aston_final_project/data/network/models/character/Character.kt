package com.kipreev.aston_final_project.data.network.models.character

data class Character(
    var created: String,
    var episode: List<String>,
    var gender: String,
    var id: Int,
    var image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
