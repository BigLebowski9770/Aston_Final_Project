package com.kipreev.aston_final_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.load
import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.models.character.Character
import com.kipreev.aston_final_project.databinding.FragmentCharacterInfoBinding
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharacterInfo : Fragment() {

    lateinit var binding: FragmentCharacterInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterInfoBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = this.arguments

        val id = args?.getInt("id character")

        Log.d("TAG FOR TEST ID", id.toString())

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val characterApi = retrofit.create(CharacterApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val character = async {
                return@async id?.let { characterApi.getSingleCharacterById(it) }
            }.await()

            Log.d("Test", "$character")

            withContext(Dispatchers.Main) {
                binding.characterInfoImage.load(character?.image.toString())
                binding.characterInfoName.text = character?.name
                binding.characterInfoStatus.text = character?.status
                binding.characterInfoSpecies.text = character?.species
                binding.characterInfoGender.text = character?.gender
                binding.characterInfoCreated.text = character?.created
            }
        }
    }

}