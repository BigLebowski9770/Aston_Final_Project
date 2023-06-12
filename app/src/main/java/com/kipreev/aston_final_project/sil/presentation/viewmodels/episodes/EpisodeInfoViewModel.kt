package com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.sil.domain.episodes.GetEpisodeInfoUseCase
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodeInfoUIModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeInfoViewModel @Inject constructor(
    private val getEpisodeInfoUseCase: GetEpisodeInfoUseCase
) : ViewModel() {

    private val _episodesInfo: MutableLiveData<EpisodeInfoUIModel> = MutableLiveData()
    val episodesInfo: LiveData<EpisodeInfoUIModel> = _episodesInfo

    fun getEpisodeInfo(episodeId: Int) {
        viewModelScope.launch {
            try {
                val response = getEpisodeInfoUseCase(episodeId)
                _episodesInfo.postValue(response)
            } catch (exception: Exception) {

            }
        }
    }
}