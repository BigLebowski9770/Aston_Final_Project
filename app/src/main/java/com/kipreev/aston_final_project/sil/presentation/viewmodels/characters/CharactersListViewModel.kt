package com.kipreev.aston_final_project.presentation.viewmodels.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.chars.Response
import com.kipreev.aston_final_project.domain.characters.GetAllCharactersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _charactersList: MutableLiveData<Response> = MutableLiveData()
    val charactersList: LiveData<Response> = _charactersList

    init {
        viewModelScope.launch {
            runCatching {
                getAllCharactersUseCase.getAllCharacters()
            }.onSuccess {
                _charactersList.postValue(it)
            }.onFailure {
                Log.e("RequestException", it.toString())
            }
        }
    }

    private fun goToNextScreen() {
        val summerSmith = getAllCharactersUseCase.charactersList?.results?.find { it.name=="Summer Smith" }
        //Todo допустим, отправляем эту модель куда-то еще
    }
}