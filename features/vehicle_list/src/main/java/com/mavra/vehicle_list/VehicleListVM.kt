package com.mavra.vehicle_list

import androidx.lifecycle.viewModelScope
import com.mavra.core.viewmodel.BaseViewModel
import com.mavra.domain.model.DomainPhoto
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VehicleListVM @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase) :
    BaseViewModel() {

    val photos: MutableStateFlow<List<DomainPhoto>> = MutableStateFlow(emptyList())

    fun getRoverPhotos() {
        fetchPhotoUseCase.execute(FetchPhotoUseCase.Request("curiosity")).dataHandling(success = {
            photos.value = it
        })
    }
}