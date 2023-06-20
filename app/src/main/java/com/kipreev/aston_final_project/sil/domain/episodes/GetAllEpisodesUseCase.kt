package com.kipreev.aston_final_project.sil.domain.episodes

import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.data.database.EpisodesDao
import javax.inject.Inject

class GetAllEpisodesUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val episodesDao: EpisodesDao
) {

    var episodesList: List<ResultEpisodeDto>? = null

    suspend fun getAllEpisodes(): List<ResultEpisodeDto> {
        val localEpisodesList = episodesDao.getAll()

        val finalEpisodesList = if (localEpisodesList.isEmpty()) {
            val result = mainRepository.getAllEpisodes().results
            saveToDatabase(result)
            result
        } else {
            localEpisodesList
        }
        episodesList = finalEpisodesList
        return finalEpisodesList
    }

    private suspend fun saveToDatabase(results: List<ResultEpisodeDto>) {
        mainRepository.saveAllEpisodes(results)
    }
}
