package com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.sil.domain.episodes.GetAllEpisodesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesListViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase
) : ViewModel() {

    private val _episodesList: MutableLiveData<List<ResultEpisodeDto>> = MutableLiveData()
    val episodesList: LiveData<List<ResultEpisodeDto>> = _episodesList

    init {
        viewModelScope.launch {
            runCatching {
                getAllEpisodesUseCase.getAllEpisodes()
            }.onSuccess {
                _episodesList.postValue(it)
            }.onFailure {
                Log.e("RequestException", it.toString())
            }
        }

    }
}