package com.kipreev.aston_final_project.domain.characters

import com.kipreev.aston_final_project.data.network.models.chars.Response
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    var charactersList: Response? = null

    suspend fun getAllCharacters(): Response {
        val response = mainRepository.getAllCharacters()
        charactersList = response
        return response
    }
}
