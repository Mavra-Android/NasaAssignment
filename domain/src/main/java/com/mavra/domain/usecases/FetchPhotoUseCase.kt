package com.mavra.domain.usecases

import com.mavra.domain.BaseFlowUseCase
import com.mavra.domain.Repository
import com.mavra.domain.model.Resource
import com.mavra.domain.model.DomainPhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

class FetchPhotoUseCase @Inject constructor(
    private val repository: Repository
) : BaseFlowUseCase<FetchPhotoUseCase.Request, List<DomainPhoto>>() {


    override fun execute(request: Request): Flow<Resource<List<DomainPhoto>>> = flow<Resource<List<DomainPhoto>>> {
        val response = repository.fetchPhotos(request.roverType)
        emit(Resource.Success(data = response))
    }

    data class Request(
        val roverType: String
    )


}
