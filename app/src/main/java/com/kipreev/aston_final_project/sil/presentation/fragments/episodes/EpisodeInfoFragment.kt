package com.kipreev.aston_final_project.sil.presentation.fragments.episodes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.FragmentEpisodeInfoBinding
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes.EpisodeInfoViewModel


class EpisodeInfoFragment : Fragment(R.layout.fragment_episode_info) {

    private val binding: FragmentEpisodeInfoBinding by viewBinding()

    private val episodeId by lazy(mode = LazyThreadSafetyMode.NONE) {
        this.arguments?.getInt(EpisodesFragment.KEY_FOR_ID_EPISODE)
    }

    private lateinit var viewModel: EpisodeInfoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()

        episodeId?.let {
            viewModel.getEpisodeInfo(it)
        }

        viewModel.episodesInfo.observe(viewLifecycleOwner) {
            bindUI(it)
        }
    }

    private fun bindUI(episode: EpisodeInfoUIModel) {
        with(binding) {
            binding.episodeInfoName.text = episode.name
            binding.episodeInfoCreated.text = episode.created
            binding.episodeInfoAirDate.text = episode.airDate
            binding.episodeInfoEpisodeCode.text = episode.episodeCode
        }
    }

    private fun initViewModel() {
        viewModel = (activity as MainActivity).episodeInfoViewModel

    }

}
