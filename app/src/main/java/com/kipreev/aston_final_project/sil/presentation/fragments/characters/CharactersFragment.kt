package com.kipreev.aston_final_project.presentation.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.data.network.models.chars.ResultCharactersDto
import com.kipreev.aston_final_project.databinding.FragmentCharactersBinding
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.presentation.adapters.CharAdapter
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharactersListViewModel

class CharactersFragment : Fragment(R.layout.fragment_characters), RVClickItem {

    private lateinit var viewModel: CharactersListViewModel

    private val binding: FragmentCharactersBinding by viewBinding()

    private val adapter: CharAdapter by lazy {
        CharAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        binding.rcViewChar.layoutManager = GridLayoutManager(context, 2)
        binding.rcViewChar.adapter = adapter
        viewModel.charactersList.observe(viewLifecycleOwner) { results ->
            adapter.submitList(results)

            binding.swiperefresh.setOnRefreshListener {

            }
        }
    }

    override fun onCharItemClick(objects: ResultCharactersDto) {
        val controller = findNavController()
        val bundle = Bundle()

        bundle.putInt(KEY_FOR_ID_CHAR, objects.id)

        controller.navigate(R.id.action_charactersFragment2_to_characterInfo2, bundle)
    }

    private fun initViewModel() {
        viewModel = (activity as MainActivity).charactersListViewModel
    }


    companion object {
        const val KEY_FOR_ID_CHAR = "id character"
    }
}