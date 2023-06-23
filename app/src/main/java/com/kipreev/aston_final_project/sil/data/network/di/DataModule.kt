package com.kipreev.aston_final_project.data.network.di

import android.content.Context
import androidx.room.Room
import com.kipreev.aston_final_project.sil.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.data.network.repo.MainRepositoryImpl
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase
import com.kipreev.aston_final_project.sil.data.database.CharactersDao
import com.kipreev.aston_final_project.sil.data.database.EpisodesDao
import com.kipreev.aston_final_project.sil.data.database.LocationsDao
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        api: CharacterApi,
        charactersDao: CharactersDao,
        episodesDao: EpisodesDao,
        locationsDao: LocationsDao
    ): MainRepository = MainRepositoryImpl(api, charactersDao, locationsDao, episodesDao)

    @Singleton
    @Provides
    fun providepApiClient(): CharacterApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
            .create(CharacterApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AstonDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            AstonDatabase::class.java,
            AstonDatabase.DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideCharactersDao(database: AstonDatabase): CharactersDao =
        database.getCharactersDao()

    @Singleton
    @Provides
    fun provideEpisodesDao(database: AstonDatabase): EpisodesDao =
        database.getEpisodesDao()

    @Singleton
    @Provides
    fun provideLocationsDao(database: AstonDatabase): LocationsDao =
        database.getLocationsDao()
}