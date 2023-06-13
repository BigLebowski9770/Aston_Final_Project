package com.kipreev.aston_final_project.presentation.fragments

import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisode
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocation

interface RVClickItem {

    fun onCharItemClick(objects: com.kipreev.aston_final_project.data.network.models.chars.Result){

    }

    fun onLocationItemClick(objects: ResultLocation){

    }

    fun onEpisodeItemClick(objects: ResultEpisode){

    }

}