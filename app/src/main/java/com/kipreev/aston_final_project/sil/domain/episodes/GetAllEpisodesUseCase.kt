package com.kipreev.aston_final_project.sil.domain.episodes

import com.kipreev.aston_final_project.data.network.models.episodes.EpisodesEpisode
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import javax.inject.Inject

class GetAllEpisodesUseCase @Inject constructor(
    private val mainRepository: MainRepository
){
    var episodesList: EpisodesEpisode? = null

    suspend fun getAllEpisode(): EpisodesEpisode {
        val response = mainRepository.getAllEpisodes()
        episodesList = response
        return response
    }
}