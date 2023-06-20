package com.kipreev.aston_final_project.sil.domain.locations

import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.data.database.LocationsDao
import javax.inject.Inject

class GetAllLocationsUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val locationsDao: LocationsDao
){
    var locationsList: List<ResultLocationDto>? = null

    suspend fun getAllLocations(): List<ResultLocationDto>? {
        val localLocationsList = locationsDao.getAll()

        val finalLocationsList = if (localLocationsList.isEmpty()){
            val result = mainRepository.getAllLocations().results
            saveToDatabase(result)
            result
        } else {
            localLocationsList
        }
        locationsList = finalLocationsList
        return finalLocationsList
    }

    private suspend fun saveToDatabase(results: List<ResultLocationDto>) {
        mainRepository.saveAllLocations(results)
    }
}