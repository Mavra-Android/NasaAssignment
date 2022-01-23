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
) : BaseFlowUseCase<FetchPhotoUseCase.Request, FetchPhotoUseCase.Result>() {


    override fun execute(request: Request): Flow<Resource<Result>> = flow<Resource<Result>> {
        val response = repository.fetchPhotos(request.roverType, request.camera)
        val result = Result(response)
        emit(Resource.Success(result))
    }

    data class Request(
        val roverType: String,
        val camera: String?
    )

    data class Result(
        val photos: List<DomainPhoto> = listOf()
    )
}
