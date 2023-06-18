package com.kipreev.aston_final_project.sil.domain.locations

import com.kipreev.aston_final_project.data.network.models.locations.LocationsLocation
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import javax.inject.Inject

class GetAllLocationsUseCase @Inject constructor(
    private val mainRepository: MainRepository
){
    var locationsList: LocationsLocation? = null

    suspend fun getAllLocations(): LocationsLocation {
        val response = mainRepository.getAllLocations()
        locationsList = response
        return response
    }
}