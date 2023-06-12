package com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.sil.domain.episodes.GetAllEpisodesUseCase
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodesFilterModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesListViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase
) : ViewModel() {

    private val _episodesList: MutableLiveData<List<ResultEpisodeDto>> = MutableLiveData()
    val episodesList: LiveData<List<ResultEpisodeDto>> = _episodesList

    private val _searchText: MutableLiveData<EpisodesFilterModel> = MutableLiveData()

    private val _isRefreshing: MutableLiveData<Boolean> = MutableLiveData()
    val isRefreshing: LiveData<Boolean> = _isRefreshing

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

    fun refreshContent() {
        viewModelScope.launch {
            runCatching {
                _isRefreshing.postValue(true)
                getAllEpisodesUseCase.updateEpisodes()
            }.onSuccess {
                _isRefreshing.postValue(false)
                _episodesList.postValue(it)
            }.onFailure {
                _isRefreshing.postValue(false)
                Log.e("RequestException", it.toString())
            }
        }
    }

    private fun filterEpisodes(updatedModel: EpisodesFilterModel) {
        viewModelScope.launch {
            runCatching {
                getAllEpisodesUseCase.filterEpisodes(updatedModel)
            }.onSuccess {
                _episodesList.postValue(it)
            }.onFailure {
                Log.e("RequestException", it.toString())
            }
        }
    }

    fun updateSearchText(
        name: String? = null,
        episode: String? = null,
    ) {
        val oldState = _searchText.value
        val updatedModel = EpisodesFilterModel(
            name = name ?: oldState?.name,
            episode = episode ?: oldState?.episode,
        )
        filterEpisodes(updatedModel)
    }
}