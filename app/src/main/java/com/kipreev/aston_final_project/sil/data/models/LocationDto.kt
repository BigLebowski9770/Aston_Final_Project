package com.kipreev.aston_final_project.sil.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase.Companion.LOCATION_TABLE_NAME

@Entity(
    tableName = LOCATION_TABLE_NAME
)
data class LocationDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val locationId: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val created: String
)
