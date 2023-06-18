package com.kipreev.aston_final_project.presentation.di

import com.kipreev.aston_final_project.domain.characters.GetAllCharactersUseCase
import com.kipreev.aston_final_project.domain.characters.GetCharacterInfoUseCase
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharacterInfoViewModel
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharactersListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

    @Singleton
    @Provides
    fun provideCharactersViewModel(
        getAllCharactersUseCase: GetAllCharactersUseCase
    ): CharactersListViewModel =
        CharactersListViewModel(
            getAllCharactersUseCase
        )

    @Singleton
    @Provides
    fun provideCharacterInfoViewModel(
        getCharacterInfoUseCase: GetCharacterInfoUseCase
    ): CharacterInfoViewModel =
        CharacterInfoViewModel(
            getCharacterInfoUseCase
        )
}