package com.kipreev.aston_final_project.domain.characters

import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.sil.domain.characters.toUI
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterInfoUIModel
import javax.inject.Inject

class GetCharacterInfoUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(characterId: Int): CharacterInfoUIModel {
        val localCharacter = mainRepository.getLocalCharacterById(characterId)
        return localCharacter?.toUI() ?: mainRepository.getSingleCharacterById(characterId).toUI()
    }
}

