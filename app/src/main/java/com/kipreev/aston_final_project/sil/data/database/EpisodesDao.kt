package com.kipreev.aston_final_project.sil.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase.Companion.EPISODE_TABLE_NAME

@Dao
interface EpisodesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(episodesDto: ResultEpisodeDto): Long

    @Query("SELECT * FROM $EPISODE_TABLE_NAME")
    suspend fun getAll(): List<ResultEpisodeDto>

    @Query("SELECT * FROM $EPISODE_TABLE_NAME WHERE id=:id")
    suspend fun findEpisodes(id: Int): ResultEpisodeDto?
}