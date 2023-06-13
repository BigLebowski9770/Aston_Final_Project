package com.kipreev.aston_final_project.data.network.api

import com.kipreev.aston_final_project.data.network.models.chars.Response
import com.kipreev.aston_final_project.data.network.models.episodes.EpisodesEpisode
import com.kipreev.aston_final_project.data.network.models.locations.LocationsLocation
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    suspend fun getAllCharacters(): Response

    @GET("location")
    suspend fun getAllLocations(): LocationsLocation

    @GET("episode")
    suspend fun getAllEpisodes(): EpisodesEpisode

    @GET("character/{id}")
    suspend fun getSingleCharacterById(@Path("id") id: Int): com.kipreev.aston_final_project.data.network.models.character.Character

}