package com.mavra.vehicle_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.mavra.core.utility.attach
import com.mavra.core.utility.linearLayoutManagerVertical
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
    private val linearLayoutManagerVertical by linearLayoutManagerVertical()

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
        binding.rvVehicleList.attach(adapter,linearLayoutManagerVertical)
    }


}