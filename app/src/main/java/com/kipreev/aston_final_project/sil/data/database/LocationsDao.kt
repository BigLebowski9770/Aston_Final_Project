package com.kipreev.aston_final_project.sil.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto

@Dao
interface LocationsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(locationDto: ResultLocationDto): Long

    @Query("SELECT * FROM ${AstonDatabase.LOCATION_TABLE_NAME}")
    suspend fun getAll(): List<ResultLocationDto>

    @Query("SELECT * FROM ${AstonDatabase.LOCATION_TABLE_NAME} WHERE id=:id")
    suspend fun findLocation(id: Int): ResultLocationDto?
}