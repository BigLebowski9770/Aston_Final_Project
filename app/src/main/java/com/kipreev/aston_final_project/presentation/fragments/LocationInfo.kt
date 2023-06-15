package com.kipreev.aston_final_project.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.data.network.api.CharacterApi
import com.kipreev.aston_final_project.databinding.FragmentCharacterInfoBinding
import com.kipreev.aston_final_project.databinding.FragmentLocationInfoBinding
import com.kipreev.aston_final_project.databinding.LocationItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationInfo : Fragment() {

    lateinit var binding: FragmentLocationInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = this.arguments

        val id = args?.getInt("id location")

        Log.d("TAG FOR TEST ID LOCATION", id.toString())

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val characterApi = retrofit.create(CharacterApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val location = async {
                return@async id?.let { characterApi.getSingleLocationById(it) }
            }.await()

            Log.d("Test", "$location")

            withContext(Dispatchers.Main) {
                binding.locationInfoName.text = location?.name
                binding.locationInfoCreated.text = location?.created
                binding.locationInfoType.text = location?.type
                binding.locationInfoDimension.text = location?.dimension
            }
        }
    }

}