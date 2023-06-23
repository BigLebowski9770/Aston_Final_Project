package com.kipreev.aston_final_project.sil.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.kipreev.aston_final_project.data.network.models.chars.LocationResponseDto
import com.kipreev.aston_final_project.data.network.models.chars.CharacterOriginResponse

class LocationsResultsDtoConverters {
    @TypeConverter
    fun locationToJson(value: LocationResponseDto?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String): LocationResponseDto =
        Gson().fromJson(value, LocationResponseDto::class.java) ?: LocationResponseDto("", "")
}

class OriginDtoConverters {
    @TypeConverter
    fun originToJson(value: CharacterOriginResponse) = Gson().toJson(value)

    @TypeConverter
    fun jsonToOrigin(value: String) = Gson().fromJson(value, CharacterOriginResponse::class.java)
}

class StringListConverters {
    @TypeConverter
    fun listStingsToJson(value: List<String>?): String = Gson().toJson(value) ?: ""

    @TypeConverter
    fun jsonToListString(value: String?) = try {
        Gson().fromJson(value, Array<String>::class.java).asList()
    } catch (e: Exception) {
        listOf()
    }
}