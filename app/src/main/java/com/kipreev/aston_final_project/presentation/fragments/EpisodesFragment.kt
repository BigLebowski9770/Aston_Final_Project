package com.kipreev.aston_final_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kipreev.aston_final_project.presentation.adapters.EpisodeAdapter
import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.models.episodes.ResultEpisode
import com.kipreev.aston_final_project.databinding.FragmentEpisodesBinding
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodesFragment : Fragment(), RVClickItem {

    private lateinit var binding: FragmentEpisodesBinding
    private val adapter = EpisodeAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcViewEpisodes.layoutManager = GridLayoutManager(context, 2)
        binding.rcViewEpisodes.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val characterApi = retrofit.create(CharacterApi::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            val list = async {
                return@async characterApi.getAllEpisodes()
            }.await()

            Log.d("Test", "$list")

            withContext(Dispatchers.Main) {
                adapter.submitList(list.results)
            }
        }

    }

    override fun onEpisodeItemClick(objects: ResultEpisode) {
        Log.d("OPOOOOOOOOOOOOOOOOOOOOO", "EPISODE ${objects.name}")
    }
}


