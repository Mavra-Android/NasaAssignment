package com.mavra.vehicle_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VehicleListVM @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase) :
    ViewModel() {
    
    fun getTest() {
        viewModelScope.launch {
            fetchPhotoUseCase.execute(FetchPhotoUseCase.Request("curiosity", "")).collect {

            }
        }
    }
}