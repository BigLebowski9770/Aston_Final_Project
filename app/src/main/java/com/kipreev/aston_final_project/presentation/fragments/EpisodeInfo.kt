package com.kipreev.aston_final_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.databinding.FragmentEpisodeInfoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class EpisodeInfo : Fragment() {

    private lateinit var binding: FragmentEpisodeInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodeInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = this.arguments

        val id = args?.getInt("id episode")

        Log.d("TAG FOR TEST ID LOCATION", id.toString())

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val characterApi = retrofit.create(CharacterApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val episode = async {
                return@async id?.let { characterApi.getSingleEpisodeById(it) }
            }.await()

            Log.d("Test", "$episode")

            withContext(Dispatchers.Main) {
                binding.episodeInfoName.text = episode?.name
                binding.episodeInfoCreated.text = episode?.created
                binding.episodeInfoAirDate.text = episode?.air_date
                binding.episodeInfoEpisodeCode.text = episode?.episode
            }
        }
    }

}