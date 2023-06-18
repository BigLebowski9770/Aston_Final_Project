package com.kipreev.aston_final_project.sil.domain.episodes

import com.kipreev.aston_final_project.data.network.models.episode.SingleEpisode
import com.kipreev.aston_final_project.sil.presentation.fragments.episodes.EpisodeInfoUIModel

fun SingleEpisode.toUI() =
    EpisodeInfoUIModel(
        id = id,
        name = name,
        airDate = air_date,
        episodeCode = episode,
        created = created
    )