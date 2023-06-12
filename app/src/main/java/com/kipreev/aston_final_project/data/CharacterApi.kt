package com.kipreev.aston_final_project.data

import com.kipreev.aston_final_project.elem.models.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("character")
    suspend fun getAllCharacters(): Response
}