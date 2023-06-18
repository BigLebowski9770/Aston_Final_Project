package com.kipreev.aston_final_project.domain.di

import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.domain.characters.GetAllCharactersUseCase
import com.kipreev.aston_final_project.domain.characters.GetCharacterInfoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideGetAllCharactersUseCase(
        mainRepository: MainRepository
    ): GetAllCharactersUseCase = GetAllCharactersUseCase(mainRepository)

    @Singleton
    @Provides
    fun provideCharacterInfoUseCase(
        mainRepository: MainRepository
    ): GetCharacterInfoUseCase = GetCharacterInfoUseCase(mainRepository)
}