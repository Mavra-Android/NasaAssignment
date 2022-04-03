package com.mavra.vehicle_list

import androidx.lifecycle.viewModelScope
import com.mavra.core.viewmodel.BaseViewModel
import com.mavra.domain.model.DomainPhoto
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VehicleListVM @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase) :
    BaseViewModel() {

    private val _photos: MutableStateFlow<List<DomainPhoto>> = MutableStateFlow(emptyList())
    val photos get() = _photos as StateFlow<List<DomainPhoto>>

    fun getRoverPhotos() {
        fetchPhotoUseCase.execute(FetchPhotoUseCase.Request("curiosity"))
            .dataHandling(success = { _photos.value = it })
    }
}