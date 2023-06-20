package com.kipreev.aston_final_project.presentation.fragments

import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto

interface RVClickItem {

    fun onCharItemClick(objects: com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto){

    }

    fun onLocationItemClick(objects: ResultLocationDto){

    }

    fun onEpisodeItemClick(objects: ResultEpisodeDto){

    }

}