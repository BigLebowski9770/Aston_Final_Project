package com.kipreev.aston_final_project.sil.domain.episodes

import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisodeDto
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodeInfoUIModel

fun ResultEpisodeDto.toUI() =
    EpisodeInfoUIModel(
        id = id,
        name = name,
        airDate = air_date,
        episodeCode = episode,
        created = created
    )