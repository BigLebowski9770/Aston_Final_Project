package com.kipreev.aston_final_project.sil.presentation.viewmodels.locations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.sil.domain.locations.GetLocationInfoUseCase
import com.kipreev.aston_final_project.sil.presentation.fragments.locations.LocationInfoUIModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationInfoViewModel @Inject constructor(
    private val getLocationInfoUseCase: GetLocationInfoUseCase
) : ViewModel() {

    private val _locationsInfo: MutableLiveData<LocationInfoUIModel> = MutableLiveData()
    val locationsInfo: LiveData<LocationInfoUIModel> = _locationsInfo

    fun getLocationInfo(locationId: Int) {
        viewModelScope.launch {
            val response = getLocationInfoUseCase(locationId)
            _locationsInfo.postValue(response)
        }
    }
}