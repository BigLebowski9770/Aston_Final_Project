package com.kipreev.aston_final_project.data.network.repo

import com.kipreev.aston_final_project.data.network.models.chars.MainCharactesResponse
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.data.network.models.episodes.MainEpisodesResponse
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.models.locations.MainLocationResponse
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterFilterModel
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodesFilterModel
import com.kipreev.aston_final_project.sil.presentation.fragments.locations.LocationFilterModel

interface MainRepository {

    suspend fun getAllCharacters(): MainCharactesResponse

    suspend fun saveAllCharacters(list: List<ResultCharactersDto>)

    suspend fun getLocalCharacterById(characterId: Int): ResultCharactersDto?


    suspend fun getAllLocations(): MainLocationResponse

    suspend fun saveAllLocations(list: List<ResultLocationDto>)

    suspend fun getLocalLocationById(locationId: Int): ResultLocationDto?


    suspend fun getAllEpisodes(): MainEpisodesResponse

    suspend fun filterEpisodes(episodesFilterModel: EpisodesFilterModel): List<ResultEpisodeDto>

    suspend fun filterCharacters(characterFilterModel: CharacterFilterModel): List<ResultCharactersDto>

    suspend fun filterLocations(locationsFilterModel: LocationFilterModel): List<ResultLocationDto>

    suspend fun saveAllEpisodes(list: List<ResultEpisodeDto>)

    suspend fun getLocalEpisodeById(episodeId: Int): ResultEpisodeDto?


    suspend fun getSingleCharacterById(id: Int): ResultCharactersDto

    suspend fun getSingleLocationById(id: Int): ResultLocationDto

    suspend fun getSingleEpisodeById(id: Int): ResultEpisodeDto


}