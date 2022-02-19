package com.mavra.vehicle_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mavra.core.view.BaseFragment
import com.mavra.vehicle_detail.databinding.FragmentVehicleDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleDetailFragment : BaseFragment<VehicleDetailVM, FragmentVehicleDetailBinding>() {
    override fun getViewModelClass() = VehicleDetailVM::class.java
    override fun getViewBinding() = FragmentVehicleDetailBinding.inflate(layoutInflater)

    override fun initUI(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        super.initUI(inflater, container, savedInstanceState)

    }


}