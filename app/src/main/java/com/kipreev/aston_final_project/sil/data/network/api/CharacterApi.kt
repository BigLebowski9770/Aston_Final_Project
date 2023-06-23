package com.kipreev.aston_final_project.sil.data.network.api

import com.kipreev.aston_final_project.data.network.models.chars.MainCharactesResponse
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.data.network.models.episodes.MainEpisodesResponse
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.models.locations.MainLocationResponse
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun getAllCharacters(
    ): MainCharactesResponse

    @GET("location")
    suspend fun getAllLocations(
    ): MainLocationResponse

    @GET("episode")
    suspend fun getAllEpisodes(
    ): MainEpisodesResponse

    @GET("episode")
    suspend fun filterEpisodes(
        @Query("name") name: String = "",
        @Query("episode") status: String = "",
    ): MainEpisodesResponse

    @GET("character")
    suspend fun filterCharacters(
        @Query("name") name: String = "",
        @Query("status") status: String = "",
        @Query("species") species: String = "",
        @Query("type") type: String = "",
        @Query("gender") gender: String = "",
    ): MainCharactesResponse

    @GET("location")
    suspend fun filterLocations(
        @Query("name") name: String = "",
        @Query("type") type: String = "",
        @Query("dimension") dimension: String = "",
    ): MainLocationResponse

    @GET("character/{id}")
    suspend fun getSingleCharacterById(@Path("id") id: Int): ResultCharactersDto

    @GET("location/{id}")
    suspend fun getSingleLocationById(@Path("id") id: Int): ResultLocationDto

    @GET("episode/{id}")
    suspend fun getSingleEpisodeById(@Path("id") id: Int): ResultEpisodeDto

}