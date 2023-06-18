package com.kipreev.aston_final_project.presentation.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.FragmentCharacterInfoBinding
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.presentation.fragments.characters.CharactersFragment.Companion.KEY_FOR_ID_CHAR
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharacterInfoViewModel
import com.kipreev.aston_final_project.sil.presentation.fragments.characters.CharacterInfoUIModel

class CharacterInfoFragment : Fragment(R.layout.fragment_character_info) {

    private val binding: FragmentCharacterInfoBinding by viewBinding()

    private val characterId by lazy(mode = LazyThreadSafetyMode.NONE) {
        this.arguments?.getInt(KEY_FOR_ID_CHAR)
    }

    private lateinit var viewModel: CharacterInfoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()

//        characterId?.let(viewModel::getCharacterInfo)
        characterId?.let {
            viewModel.getCharacterInfo(it)
        }

        viewModel.charactersInfo.observe(viewLifecycleOwner) {
            bindUI(it)
        }
    }

    private fun bindUI(characterInfo: CharacterInfoUIModel) {
        with(binding) {
            characterInfoImage.load(characterInfo.imageUrl)
            characterInfoName.text = characterInfo.name
            characterInfoStatus.text = characterInfo.status
            characterInfoSpecies.text = characterInfo.species
            characterInfoGender.text = characterInfo.gender
            characterInfoCreated.text = characterInfo.created
        }
    }

    private fun initViewModel() {
        viewModel = (activity as MainActivity).characterInfoViewModel

    }

}