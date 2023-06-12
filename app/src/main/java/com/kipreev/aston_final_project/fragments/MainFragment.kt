package com.kipreev.aston_final_project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kipreev.aston_final_project.R

class MainFragment : Fragment() {

    private lateinit var btnChar: Button
    private lateinit var btnLocation: Button
    private lateinit var btnEpisodes: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = findNavController()

        btnChar = view.findViewById<Button?>(R.id.button_characters)
        btnLocation = view.findViewById(R.id.button_locations)
        btnEpisodes = view.findViewById(R.id.button_episodes)

        btnChar.setOnClickListener { controller.navigate(R.id.charactersFragment) }
        btnLocation.setOnClickListener { controller.navigate(R.id.locationsFragment) }
        btnEpisodes.setOnClickListener { controller.navigate(R.id.episodesFragment) }
    }
}