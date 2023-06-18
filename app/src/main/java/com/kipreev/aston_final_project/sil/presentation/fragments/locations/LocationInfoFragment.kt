package com.kipreev.aston_final_project.sil.presentation.fragments.locations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kipreev.aston_final_project.R
import com.kipreev.aston_final_project.databinding.FragmentLocationInfoBinding
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.sil.presentation.viewmodels.locations.LocationInfoViewModel


class LocationInfoFragment : Fragment(R.layout.fragment_location_info) {

    private val binding: FragmentLocationInfoBinding by viewBinding()

    private val locationId by lazy(mode = LazyThreadSafetyMode.NONE) {
        this.arguments?.getInt(LocationsFragment.KEY_FOR_ID_LOCATION)
    }

    private lateinit var viewModel: LocationInfoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()

        locationId?.let {
            viewModel.getLocationInfo(it)
        }

        viewModel.locationsInfo.observe(viewLifecycleOwner) {
            bindUI(it)
        }
    }

    private fun bindUI(location: LocationInfoUIModel) {
        with(binding) {
            binding.locationInfoName.text = location.name
            binding.locationInfoCreated.text = location.created
            binding.locationInfoType.text = location.type
            binding.locationInfoDimension.text = location.dimension
        }
    }

    private fun initViewModel() {
        viewModel = (activity as MainActivity).locationInfoViewModel

    }
}

