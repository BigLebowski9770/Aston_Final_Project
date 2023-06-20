package com.kipreev.aston_final_project.sil.domain.characters

import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.data.database.CharactersDao
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val charactersDao: CharactersDao
) {
    var charactersList: List<ResultCharactersDto>? = null

    suspend fun getAllCharacters(): List<ResultCharactersDto> {
        val localCharactersList = charactersDao.getAll()

        val finalCharactersList = if (localCharactersList.isEmpty()) {
            val result = mainRepository.getAllCharacters().results
            saveToDatabase(result)
            result
        } else {
            localCharactersList
        }
        charactersList = finalCharactersList
        return finalCharactersList
    }

    private suspend fun saveToDatabase(results: List<ResultCharactersDto>) {
        mainRepository.saveAllCharacters(results)
    }
}
