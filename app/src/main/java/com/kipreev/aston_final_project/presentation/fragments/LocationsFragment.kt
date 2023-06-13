package com.kipreev.aston_final_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kipreev.aston_final_project.presentation.adapters.LocationAdapter
import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocation
import com.kipreev.aston_final_project.databinding.FragmentLocationsBinding
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationsFragment : Fragment(), RVClickItem {

    lateinit var binding: FragmentLocationsBinding
    private lateinit var adapter: LocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LocationAdapter(this)
        binding.rcViewLocation.layoutManager = GridLayoutManager(context, 2)
        binding.rcViewLocation.adapter = adapter

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val characterApi = retrofit.create(CharacterApi::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            val list = async {
                return@async characterApi.getAllLocations()
            }.await()

            Log.d("Test", "$list")

            withContext(Dispatchers.Main) {
                adapter.submitList(list.results)
            }
        }
    }

    override fun onLocationItemClick(objects: ResultLocation) {
        Log.d("OPOOOOOOOOOOOOOOOOOOOOO", "LOCATIONS ${objects.name}")
    }
}