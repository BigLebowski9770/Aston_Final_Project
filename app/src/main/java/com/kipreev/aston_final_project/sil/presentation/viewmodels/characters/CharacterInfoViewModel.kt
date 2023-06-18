package com.kipreev.aston_final_project.presentation.viewmodels.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.domain.characters.GetCharacterInfoUseCase
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterInfoUIModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterInfoViewModel @Inject constructor(
    private val getCharacterInfoUseCase: GetCharacterInfoUseCase
) : ViewModel() {

    private val _charactersInfo: MutableLiveData<CharacterInfoUIModel> = MutableLiveData()
    val charactersInfo: LiveData<CharacterInfoUIModel> = _charactersInfo

    fun getCharacterInfo(characterId: Int) {
        viewModelScope.launch {
            val response = getCharacterInfoUseCase(characterId)
            _charactersInfo.postValue(response)
        }
    }
}