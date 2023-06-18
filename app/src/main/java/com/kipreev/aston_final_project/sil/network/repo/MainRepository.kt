package com.kipreev.aston_final_project.data.network.repo

import com.kipreev.aston_final_project.data.network.models.character.CharacterInfoResponse
import com.kipreev.aston_final_project.data.network.models.chars.Response
import com.kipreev.aston_final_project.data.network.models.episode.SingleEpisode
import com.kipreev.aston_final_project.data.network.models.episodes.EpisodesEpisode
import com.kipreev.aston_final_project.data.network.models.location.SingleLocation
import com.kipreev.aston_final_project.data.network.models.locations.LocationsLocation

interface MainRepository {

    suspend fun getAllCharacters(): Response

    suspend fun getAllLocations(): LocationsLocation

    suspend fun getAllEpisodes(): EpisodesEpisode

    suspend fun getSingleCharacterById(id: Int): CharacterInfoResponse

    suspend fun getSingleLocationById(id: Int): SingleLocation

    suspend fun getSingleEpisodeById(id: Int): SingleEpisode


}