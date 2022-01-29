package com.mavra.vehicle_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mavra.core.utility.vertical
import com.mavra.core.view.BaseFragment
import com.mavra.vehicle_list.databinding.FragmentVehicleListBinding
import com.mavra.vehicle_list.widget.RoverListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class VehicleListFragment : BaseFragment<VehicleListVM, FragmentVehicleListBinding>() {
    override fun getViewModelClass() = VehicleListVM::class.java
    override fun getViewBinding() = FragmentVehicleListBinding.inflate(layoutInflater)
    private val adapter by lazy { RoverListAdapter() }

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.initUI(inflater, container, savedInstanceState)
        viewModel.getRoverPhotos()

        this.lifecycleScope.launchWhenStarted {
            viewModel.photos.collect {
                adapter.submitList(it)
            }
        }
        adapter.vertical(binding.rvVehicleList)
    }

    override fun onDestroyView() {
        binding.rvVehicleList.adapter = null
        binding.rvVehicleList.layoutManager = null
        super.onDestroyView()
    }

}