package com.kipreev.aston_final_project.sil.presentation.viewmodels.locations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.locations.LocationsLocation
import com.kipreev.aston_final_project.sil.domain.locations.GetAllLocationsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class LocationsListViewModel @Inject constructor(
    private val getAllLocationsUseCase: GetAllLocationsUseCase
) : ViewModel() {

    private val _locationsList: MutableLiveData<LocationsLocation> = MutableLiveData()
    val locationsList: LiveData<LocationsLocation> = _locationsList

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

    private fun goToNextScreen() {
        val summerSmith = getAllLocationsUseCase.locationsList?.results?.find { it.name=="Summer Smith" }
        //Todo допустим, отправляем эту модель куда-то еще
    }
}