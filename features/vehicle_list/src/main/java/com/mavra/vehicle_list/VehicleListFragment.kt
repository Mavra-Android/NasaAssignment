package com.mavra.vehicle_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import com.mavra.core.utility.attach
import com.mavra.core.utility.linearLayoutManagerVertical
import com.mavra.core.view.BaseFragment
import com.mavra.domain.model.DomainPhoto
import com.mavra.vehicle_list.databinding.FragmentVehicleListBinding
import com.mavra.vehicle_list.widget.RoverListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class VehicleListFragment : BaseFragment<VehicleListVM, FragmentVehicleListBinding>() {
    override fun getViewModelClass() = VehicleListVM::class.java
    override fun getViewBinding() = FragmentVehicleListBinding.inflate(layoutInflater)
    private val adapter by lazy { RoverListAdapter(::handleAdapterEvent) }

    private val linearLayoutManagerVertical by linearLayoutManagerVertical()

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.initUI(inflater, container, savedInstanceState)
        with(viewModel){
            photos.onEach(::onEachResult).launchIn(viewLifecycleOwner.lifecycleScope)
            viewModel.getRoverPhotos()
        }

        binding.rvVehicleList.attach(
            adapter = adapter,
            layoutManager = linearLayoutManagerVertical,
            viewLifecycleOwner = viewLifecycleOwner
        )
    }

    private fun onEachResult(photos: List<DomainPhoto>){
            adapter.submitList(photos)
    }

    private fun handleAdapterEvent(event: RoverListAdapter.Event) {
        when (event) {
            is RoverListAdapter.Event.OnShowDetail -> VehicleListFragmentDirections.globalDetail(
                event.photo.imageId
            ).let(findNavController()::navigate)
        }
    }

}