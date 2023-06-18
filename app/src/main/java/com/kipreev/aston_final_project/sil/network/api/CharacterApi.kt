package com.kipreev.aston_final_project.data.network.api

import com.kipreev.aston_final_project.data.network.models.character.CharacterInfoResponse
import com.kipreev.aston_final_project.data.network.models.chars.Response
import com.kipreev.aston_final_project.data.network.models.episode.SingleEpisode
import com.kipreev.aston_final_project.data.network.models.episodes.EpisodesEpisode
import com.kipreev.aston_final_project.data.network.models.location.SingleLocation
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
    suspend fun getSingleCharacterById(@Path("id") id: Int): CharacterInfoResponse

    @GET("location/{id}")
    suspend fun getSingleLocationById(@Path("id") id: Int): SingleLocation

    @GET("episode/{id}")
    suspend fun getSingleEpisodeById(@Path("id") id: Int): SingleEpisode

}