package com.mavra.vehicle_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mavra.domain.model.Resource
import com.mavra.shared.utility.vertical
import com.mavra.vehicle_list.databinding.FragmentVehicleListBinding
import com.mavra.vehicle_list.widget.RoverListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class VehicleListFragment : Fragment(R.layout.fragment_vehicle_list) {

    private val viewModel by viewModels<VehicleListVM>()
    private val adapter by lazy { RoverListAdapter() }
    private lateinit var binding:FragmentVehicleListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVehicleListBinding.inflate(inflater)
        viewModel.getRoverPhotos()

        this.lifecycleScope.launchWhenStarted {
            viewModel.photos.collect {
                adapter.submitList(it)
            }
        }
        adapter.vertical(binding.rvVehicleList)
        return binding.root
    }
}