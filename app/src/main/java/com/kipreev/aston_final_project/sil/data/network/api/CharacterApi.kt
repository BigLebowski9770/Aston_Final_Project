package com.kipreev.aston_final_project.data.network.api

import com.kipreev.aston_final_project.data.network.models.chars.MainCharactesResponse
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.data.network.models.episodes.MainEpisodesResponse
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.models.locations.MainLocationResponse
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    suspend fun getAllCharacters(): MainCharactesResponse

    @GET("location")
    suspend fun getAllLocations(): MainLocationResponse

    @GET("episode")
    suspend fun getAllEpisodes(): MainEpisodesResponse

    @GET("character/{id}")
    suspend fun getSingleCharacterById(@Path("id") id: Int): ResultCharactersDto

    @GET("location/{id}")
    suspend fun getSingleLocationById(@Path("id") id: Int): ResultLocationDto

    @GET("episode/{id}")
    suspend fun getSingleEpisodeById(@Path("id") id: Int): ResultEpisodeDto

}