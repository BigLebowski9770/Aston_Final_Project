package com.kipreev.aston_final_project.data.network.di

import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.repo.MainRepository
import com.kipreev.aston_final_project.data.network.repo.MainRepositoryImpl
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
        api: CharacterApi
    ): MainRepository = MainRepositoryImpl(api)

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
}