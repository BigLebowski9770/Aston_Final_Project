package com.kipreev.aston_final_project.sil.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto

@Database(
    entities = [ResultCharactersDto::class, ResultEpisodeDto::class, ResultLocationDto::class],
    version = 1
)
abstract class AstonDatabase : RoomDatabase() {

    abstract fun getCharactersDao(): CharactersDao

    abstract fun getEpisodesDao(): EpisodesDao

    abstract fun getLocationsDao(): LocationsDao

    companion object {
        const val CHARACTER_TABLE_NAME = "characters"
        const val EPISODE_TABLE_NAME = "episodes"
        const val LOCATION_TABLE_NAME = "locations"

        const val DATABASE_NAME = "aston_db"
    }
}