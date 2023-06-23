package com.kipreev.aston_final_project.sil.presentation.fragments.locations

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.presentation.adapters.LocationAdapter
import com.kipreev.aston_final_project.data.network.models.locations.ResultLocationDto
import com.kipreev.aston_final_project.databinding.FragmentLocationsBinding
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.presentation.fragments.RVClickItem
import com.kipreev.aston_final_project.sil.presentation.viewmodels.locations.LocationsListViewModel

class LocationsFragment : Fragment(R.layout.fragment_locations), RVClickItem {

    private lateinit var viewModel: LocationsListViewModel

    private val binding: FragmentLocationsBinding by viewBinding()

    private val adapter: LocationAdapter by lazy {
        LocationAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        with(binding) {
           rcViewLocation.layoutManager = GridLayoutManager(context, 2)
           rcViewLocation.adapter = adapter
            viewModel.locationsList.observe(viewLifecycleOwner) { response ->
                adapter.submitList(response)
            }
            swiperefresh.setOnRefreshListener {
                viewModel.refreshContent()
            }
            viewModel.isRefreshing.observe(viewLifecycleOwner) {
                swiperefresh.isRefreshing = it

            }
            searchName.doOnTextChanged { text, _, _, _ ->
                viewModel.updateSearchText(name = text.toString())
            }

            searchType.doOnTextChanged { text, _, _, _ ->
                viewModel.updateSearchText(type = text.toString())
            }
            searchDimension.doOnTextChanged { text, _, _, _ ->
                viewModel.updateSearchText(dimension = text.toString())
            }
        }
    }

    override fun onLocationItemClick(objects: ResultLocationDto) {
        val controller = findNavController()
        val bundle = Bundle()

        bundle.putInt(KEY_FOR_ID_LOCATION, objects.id)

        controller.navigate(R.id.action_locationsFragment2_to_locationInfo3, bundle)
    }

    private fun initViewModel() {
        viewModel = (activity as MainActivity).locationsListViewModel
    }

    companion object {
        const val KEY_FOR_ID_LOCATION = "id location"
    }
}