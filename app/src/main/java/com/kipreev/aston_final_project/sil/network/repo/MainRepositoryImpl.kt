package com.kipreev.aston_final_project.data.network.repo

import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.models.character.CharacterInfoResponse
import com.kipreev.aston_final_project.data.network.models.chars.Response
import com.kipreev.aston_final_project.data.network.models.episode.SingleEpisode
import com.kipreev.aston_final_project.data.network.models.episodes.EpisodesEpisode
import com.kipreev.aston_final_project.data.network.models.location.SingleLocation
import com.kipreev.aston_final_project.data.network.models.locations.LocationsLocation
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    val api: CharacterApi
) : MainRepository {
    override suspend fun getAllCharacters(): Response {
       return api.getAllCharacters()
    }

    override suspend fun getAllLocations(): LocationsLocation {
        return api.getAllLocations()
    }

    override suspend fun getAllEpisodes(): EpisodesEpisode {
        return api.getAllEpisodes()
    }

    override suspend fun getSingleCharacterById(id: Int): CharacterInfoResponse {
        return api.getSingleCharacterById(id)
    }

    override suspend fun getSingleLocationById(id: Int): SingleLocation {
        return api.getSingleLocationById(id)
    }

    override suspend fun getSingleEpisodeById(id: Int): SingleEpisode {
        return api.getSingleEpisodeById(id)
    }
}