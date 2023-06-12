package com.kipreev.aston_final_project.presentation.viewmodels.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.sil.domain.characters.GetAllCharactersUseCase
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterFilterModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _charactersList: MutableLiveData<List<ResultCharactersDto>> = MutableLiveData()
    val charactersList: LiveData<List<ResultCharactersDto>> = _charactersList

    private val _isRefreshing: MutableLiveData<Boolean> = MutableLiveData()
    val isRefreshing: LiveData<Boolean> = _isRefreshing

    private val _searchText: MutableLiveData<CharacterFilterModel> = MutableLiveData()

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

    fun refreshContent() {
        viewModelScope.launch {
            runCatching {
                _isRefreshing.postValue(true)
                getAllCharactersUseCase.updateLocations()
            }.onSuccess {
                _isRefreshing.postValue(false)
                _charactersList.postValue(it)
            }.onFailure {
                _isRefreshing.postValue(false)
                Log.e("RequestException", it.toString())
            }
        }
    }

    private fun filterEpisodes(updatedModel: CharacterFilterModel) {
        viewModelScope.launch {
            runCatching {
                getAllCharactersUseCase.filterEpisodes(updatedModel)
            }.onSuccess {
                _charactersList.postValue(it)
            }.onFailure {
                Log.e("RequestException", it.toString())
            }
        }
    }

    fun updateSearchText(
        name: String? = null,
        status: String? = null,
        species: String? = null,
        type: String? = null,
        gender: String? = null
    ) {
        val oldState = _searchText.value
        val updatedModel = CharacterFilterModel(
            name = name ?: oldState?.gender,
            status = status ?: oldState?.status,
            species = species ?: oldState?.species,
            type = type ?: oldState?.type,
            gender = gender ?: oldState?.gender,
        )
        filterEpisodes(updatedModel)
    }

}