package com.kipreev.aston_final_project.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.kipreev.aston_final_project.AstonApp
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharacterInfoViewModel
import com.kipreev.aston_final_project.presentation.viewmodels.characters.CharactersListViewModel
import com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes.EpisodeInfoViewModel
import com.kipreev.aston_final_project.sil.presentation.viewmodels.episodes.EpisodesListViewModel
import com.kipreev.aston_final_project.sil.presentation.viewmodels.locations.LocationInfoViewModel
import com.kipreev.aston_final_project.sil.presentation.viewmodels.locations.LocationsListViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var charactersListViewModel: CharactersListViewModel

    @Inject
    lateinit var characterInfoViewModel: CharacterInfoViewModel

    @Inject
    lateinit var locationsListViewModel: LocationsListViewModel

    @Inject
    lateinit var locationInfoViewModel: LocationInfoViewModel

    @Inject
    lateinit var episodesListViewModel: EpisodesListViewModel

    @Inject
    lateinit var episodeInfoViewModel: EpisodeInfoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AstonApp.component.injectMainAcivity(this)

        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))

    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.fragmentContainerView)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}