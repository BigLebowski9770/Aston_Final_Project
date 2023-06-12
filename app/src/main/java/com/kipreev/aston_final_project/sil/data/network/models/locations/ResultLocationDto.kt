package com.kipreev.aston_final_project.data.network.models.locations

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase
import com.kipreev.aston_final_project.sil.data.database.StringListConverters

@Entity(
    tableName = AstonDatabase.LOCATION_TABLE_NAME
)
@TypeConverters(StringListConverters::class)
data class ResultLocationDto(
    @PrimaryKey(autoGenerate = true)
    val tableId: Int? = null,
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)