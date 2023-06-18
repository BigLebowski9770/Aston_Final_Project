package com.kipreev.aston_final_project.sil.domain.episodes

import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodeInfoUIModel
import javax.inject.Inject

class GetEpisodeInfoUseCase  @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(episodeId: Int): EpisodeInfoUIModel =
        mainRepository.getSingleEpisodeById(episodeId).toUI()
}