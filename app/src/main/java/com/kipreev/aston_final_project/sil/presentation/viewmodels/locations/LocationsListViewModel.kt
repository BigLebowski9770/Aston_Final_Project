package com.kipreev.aston_final_project.sil.presentation.viewmodels.locations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.sil.domain.locations.GetAllLocationsUseCase
import com.kipreev.aston_final_project.sil.presentation.fragments.locations.LocationFilterModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class LocationsListViewModel @Inject constructor(
    private val getAllLocationsUseCase: GetAllLocationsUseCase
) : ViewModel() {

    private val _locationsList: MutableLiveData<List<ResultLocationDto>> = MutableLiveData()
    val locationsList: LiveData<List<ResultLocationDto>> = _locationsList

    private val _searchText: MutableLiveData<LocationFilterModel> = MutableLiveData()

    private val _isRefreshing: MutableLiveData<Boolean> = MutableLiveData()
    val isRefreshing: LiveData<Boolean> = _isRefreshing

    init {
        viewModelScope.launch {
            runCatching {
                getAllLocationsUseCase.getAllLocations()
            }.onSuccess {
                _locationsList.postValue(it)
            }.onFailure {
                Log.e("RequestException", it.toString())
            }
        }
    }

    fun refreshContent() {
        viewModelScope.launch {
            runCatching {
                _isRefreshing.postValue(true)
                getAllLocationsUseCase.updateLocations()
            }.onSuccess {
                _isRefreshing.postValue(false)
                _locationsList.postValue(it)
            }.onFailure {
                _isRefreshing.postValue(false)
                Log.e("RequestException", it.toString())
            }
        }
    }

    private fun filterEpisodes(updatedModel: LocationFilterModel) {
        viewModelScope.launch {
            runCatching {
                getAllLocationsUseCase.filterEpisodes(updatedModel)
            }.onSuccess {
                _locationsList.postValue(it)
            }.onFailure {
                Log.e("RequestException", it.toString())
            }
        }
    }

    fun updateSearchText(
        name: String? = null,
        type: String? = null,
        dimension: String? = null,
    ) {
        val oldState = _searchText.value
        val updatedModel = LocationFilterModel(
            name = name ?: oldState?.name,
            type = type ?: oldState?.type,
            dimension = dimension ?: oldState?.dimension
        )
        filterEpisodes(updatedModel)
    }
}