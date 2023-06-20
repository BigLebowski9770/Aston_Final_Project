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
    fun locationToJson(value: CharacterOriginResponse) = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String) = Gson().fromJson(value, CharacterOriginResponse::class.java)
}

class StringListConverters {
    @TypeConverter
    fun locationToJson(value: List<String>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToLocation(value: String) = Gson().fromJson(value, Array<String>::class.java).asList()
}