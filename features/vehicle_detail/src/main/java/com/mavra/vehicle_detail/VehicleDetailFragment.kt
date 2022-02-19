package com.mavra.vehicle_detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.mavra.core.utility.loadImage
import com.mavra.core.view.BaseFragment
import com.mavra.domain.model.DomainPhotoDetail
import com.mavra.vehicle_detail.databinding.FragmentVehicleDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class VehicleDetailFragment : BaseFragment<VehicleDetailVM, FragmentVehicleDetailBinding>() {
    override fun getViewModelClass() = VehicleDetailVM::class.java
    override fun getViewBinding() = FragmentVehicleDetailBinding.inflate(layoutInflater)

    private val args by navArgs<VehicleDetailFragmentArgs>()

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) {
        super.initUI(inflater, container, savedInstanceState)
        with(viewModel) {
            result.onEach(::onEachResult).launchIn(viewLifecycleOwner.lifecycleScope)
            fetchVehicleDetail(id = args.id)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun onEachResult(result: DomainPhotoDetail) {
        binding.ivRover.loadImage(result.imagePath)
        binding.roverName.text = "Rover: ${result.roverName}"
        binding.cameraName.text = "Camera: ${result.cameraName}"
        binding.launch.text = "Launch: ${result.launchDate} / Landing: ${result.landingDate}"
        binding.date.text = result.date
    }


}