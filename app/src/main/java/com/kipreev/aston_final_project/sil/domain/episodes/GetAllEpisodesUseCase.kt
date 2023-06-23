package com.kipreev.aston_final_project.sil.domain.episodes

import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.data.database.EpisodesDao
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodesFilterModel
import javax.inject.Inject

class GetAllEpisodesUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val episodesDao: EpisodesDao
) {

    suspend fun getAllEpisodes(): List<ResultEpisodeDto> {
        val localEpisodesList = episodesDao.getAll()

        val finalEpisodesList = if (localEpisodesList.isEmpty()) {
            val result = mainRepository.getAllEpisodes().results
            saveToDatabase(result)
            result
        } else {
            localEpisodesList
        }
        return finalEpisodesList
    }

    suspend fun updateEpisodes():List<ResultEpisodeDto>{
        val result = mainRepository.getAllEpisodes().results
        saveToDatabase(result)
        return result
    }

    suspend fun filterEpisodes(episodesFilterModel: EpisodesFilterModel): List<ResultEpisodeDto> {
        return mainRepository.filterEpisodes(episodesFilterModel)
    }

    private suspend fun saveToDatabase(results: List<ResultEpisodeDto>) {
        mainRepository.saveAllEpisodes(results)
    }
}
