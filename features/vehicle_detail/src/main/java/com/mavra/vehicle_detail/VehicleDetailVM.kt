package com.mavra.vehicle_detail

import com.mavra.core.viewmodel.BaseViewModel
import com.mavra.domain.model.DomainPhotoDetail
import com.mavra.domain.usecases.FetchPhotoDetailUseCase
import com.mavra.domain.usecases.FetchPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class VehicleDetailVM @Inject constructor(private val fetchPhotoDetailUseCase: FetchPhotoDetailUseCase) :
    BaseViewModel() {

    private val _result = MutableStateFlow(DomainPhotoDetail())
    val result get() = _result as StateFlow<DomainPhotoDetail>

    fun fetchVehicleDetail(id: String) {
        fetchPhotoDetailUseCase
            .execute(FetchPhotoDetailUseCase.Request("curiosity", id))
            .dataHandling(success = { _result.value = it })
    }
}