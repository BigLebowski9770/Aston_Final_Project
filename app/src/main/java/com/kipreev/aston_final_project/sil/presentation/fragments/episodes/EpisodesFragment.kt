package com.kipreev.aston_final_project.sil.presentation.fragments.episodes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.presentation.adapters.EpisodeAdapter
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisode
import com.kipreev.aston_final_project.databinding.FragmentEpisodesBinding
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem
import com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes.EpisodesListViewModel

class EpisodesFragment : Fragment(R.layout.fragment_episodes), RVClickItem {

    private lateinit var viewModel: EpisodesListViewModel

    private val binding: FragmentEpisodesBinding by viewBinding()

    private val adapter: EpisodeAdapter by lazy {
        EpisodeAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        binding.rcViewEpisodes.layoutManager = GridLayoutManager(context, 2)
        binding.rcViewEpisodes.adapter = adapter
        viewModel.episodesList.observe(viewLifecycleOwner) { response ->
            adapter.submitList(response.results)
        }
    }

    override fun onEpisodeItemClick(objects: ResultEpisode) {
        val controller = findNavController()
        val bundle = Bundle()

        bundle.putInt(KEY_FOR_ID_EPISODE, objects.id)

        controller.navigate(R.id.action_episodesFragment2_to_episodeInfo3, bundle)
    }

    private fun initViewModel() {
        viewModel = (activity as MainActivity).episodesListViewModel
    }

    companion object {
        const val KEY_FOR_ID_EPISODE = "id episode"
    }
}


