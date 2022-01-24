package com.mavra.vehicle_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mavra.domain.model.DomainPhoto
import com.mavra.domain.model.Resource
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VehicleListVM @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase) :
    ViewModel() {

    val photos: MutableStateFlow<List<DomainPhoto>> = MutableStateFlow(emptyList())

    fun getRoverPhotos() {
        viewModelScope.launch {
            fetchPhotoUseCase.execute(FetchPhotoUseCase.Request("curiosity")).collect {
                    when(it.status){
                        Resource.Status.SUCCESS ->{
                            photos.value = (it as Resource.Success).data
                        }
                    }
            }
        }
    }
}