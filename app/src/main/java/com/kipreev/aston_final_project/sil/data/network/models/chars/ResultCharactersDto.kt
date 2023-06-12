package com.kipreev.aston_final_project.data.network.models.chars

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase
import com.kipreev.aston_final_project.sil.data.database.LocationsResultsDtoConverters
import com.kipreev.aston_final_project.sil.data.database.OriginDtoConverters
import com.kipreev.aston_final_project.sil.data.database.StringListConverters

@Entity(
    tableName = AstonDatabase.CHARACTER_TABLE_NAME
)
@TypeConverters(
    LocationsResultsDtoConverters::class, OriginDtoConverters::class,
    StringListConverters::class)
data class ResultCharactersDto(
    @PrimaryKey(autoGenerate = true)
    val tableId: Int? = null,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val locationDto: LocationResponseDto,
    val name: String,
    val origin: CharacterOriginResponse,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
