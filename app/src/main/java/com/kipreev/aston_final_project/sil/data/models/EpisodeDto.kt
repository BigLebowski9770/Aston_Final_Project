package com.kipreev.aston_final_project.sil.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase.Companion.EPISODE_TABLE_NAME

@Entity(
    tableName = EPISODE_TABLE_NAME
)
data class EpisodeDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val episodeId: Int,
    val name: String,
    val airDate: String,
    val episodeCode: String,
    val created: String
)
