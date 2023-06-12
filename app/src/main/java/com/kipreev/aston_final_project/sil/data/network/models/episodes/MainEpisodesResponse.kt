package com.kipreev.aston_final_project.data.network.models.episodes

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase
import com.kipreev.aston_final_project.sil.data.database.StringListConverters

data class MainEpisodesResponse(
    val info: InfoEpisodeResponse,
    val results: List<ResultEpisodeDto>
)

data class InfoEpisodeResponse(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

@Entity(
    tableName = AstonDatabase.EPISODE_TABLE_NAME
)
@TypeConverters(StringListConverters::class)
data class ResultEpisodeDto(
    @PrimaryKey(autoGenerate = true)
    val tableId: Int? = null,
    val air_date: String,
    val character: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)