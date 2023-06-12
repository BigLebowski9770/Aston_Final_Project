package com.kipreev.aston_final_project.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kipreev.aston_final_project.databinding.FragmentCharactersBinding
import com.kipreev.aston_final_project.adapters.CharAdapter
import com.kipreev.aston_final_project.data.CharacterApi
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment : Fragment() {

    lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter: CharAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CharAdapter()
        binding.rcView.layoutManager = GridLayoutManager(context, 2)
        binding.rcView.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val characterApi = retrofit.create(CharacterApi::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            val list = async {
                return@async characterApi.getAllCharacters()
            }.await()

            Log.d("Test", "$list")

            withContext(Dispatchers.Main) {
                adapter.submitList(list.results)
            }
        }
    }
}