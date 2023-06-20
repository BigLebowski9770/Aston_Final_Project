package com.kipreev.aston_final_project.data.network.repo

import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.models.chars.MainCharactesResponse
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.data.network.models.episodes.MainEpisodesResponse
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.models.locations.MainLocationResponse
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.sil.data.database.CharactersDao
import com.kipreev.aston_final_project.sil.data.database.EpisodesDao
import com.kipreev.aston_final_project.sil.data.database.LocationsDao
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    val api: CharacterApi,
    private val charactersDao: CharactersDao,
    private val locationsDao: LocationsDao,
    private val episodesDao: EpisodesDao
) : MainRepository {
    override suspend fun getAllCharacters(): MainCharactesResponse {
        return api.getAllCharacters()
    }

    override suspend fun saveAllCharacters(list: List<ResultCharactersDto>) {
        list.forEach {
            charactersDao.insert(it)
        }
    }

    override suspend fun getLocalCharacterById(characterId: Int): ResultCharactersDto? =
        charactersDao.findCharacter(characterId)

    override suspend fun getAllLocations(): MainLocationResponse {
        return api.getAllLocations()
    }

    override suspend fun saveAllLocations(list: List<ResultLocationDto>) {
        list.forEach {
            locationsDao.insert(it)
        }
    }

    override suspend fun getLocalLocationById(locationId: Int): ResultLocationDto? =
         locationsDao.findLocation(locationId)


    override suspend fun getAllEpisodes(): MainEpisodesResponse {
        return api.getAllEpisodes()
    }

    override suspend fun saveAllEpisodes(list: List<ResultEpisodeDto>) {
        list.forEach {
            episodesDao.insert(it)
        }
    }

    override suspend fun getLocalEpisodeById(episodeId: Int): ResultEpisodeDto? =
        episodesDao.findEpisodes(episodeId)


    override suspend fun getSingleCharacterById(id: Int): ResultCharactersDto {
        return api.getSingleCharacterById(id)
    }

    override suspend fun getSingleLocationById(id: Int): ResultLocationDto {
        return api.getSingleLocationById(id)
    }

    override suspend fun getSingleEpisodeById(id: Int): ResultEpisodeDto {
        return api.getSingleEpisodeById(id)
    }
}