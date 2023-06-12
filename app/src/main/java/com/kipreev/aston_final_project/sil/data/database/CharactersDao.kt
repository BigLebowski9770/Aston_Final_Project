package com.kipreev.aston_final_project.sil.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.sil.data.database.AstonDatabase.Companion.CHARACTER_TABLE_NAME

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterDto: ResultCharactersDto): Long

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME")
    suspend fun getAll(): List<ResultCharactersDto>

    @Query("SELECT * FROM $CHARACTER_TABLE_NAME WHERE id=:id")
    suspend fun findCharacter(id: Int): ResultCharactersDto?
}