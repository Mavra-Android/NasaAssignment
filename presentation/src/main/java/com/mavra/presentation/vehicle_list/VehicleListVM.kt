package com.mavra.presentation.vehicle_list

import androidx.lifecycle.ViewModel
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleListVM @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase):ViewModel(){
    fun fetchVehiclePhotos(){

        fetchPhotoUseCase.execute(FetchPhotoUseCase.Request("a","s"))
    }
}