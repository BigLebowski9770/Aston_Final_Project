package com.kipreev.aston_final_project.sil.domain.locations

import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.presentation.fragments.locations.LocationInfoUIModel
import javax.inject.Inject

class GetLocationInfoUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(locationId: Int): LocationInfoUIModel {
        val localLocation = mainRepository.getLocalLocationById(locationId)
        return localLocation?.toUI() ?: mainRepository.getSingleLocationById(locationId).toUI()
    }
}