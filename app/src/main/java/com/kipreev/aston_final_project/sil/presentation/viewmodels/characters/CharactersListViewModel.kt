package com.kipreev.aston_final_project.presentation.viewmodels.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.sil.domain.characters.GetAllCharactersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _charactersList: MutableLiveData<List<ResultCharactersDto>> = MutableLiveData()
    val charactersList: LiveData<List<ResultCharactersDto>> = _charactersList

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

}