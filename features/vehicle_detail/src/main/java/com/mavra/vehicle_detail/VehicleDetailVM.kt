package com.mavra.vehicle_detail

import com.mavra.core.viewmodel.BaseViewModel
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleDetailVM @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase) :
    BaseViewModel() {
}