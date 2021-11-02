package com.mavra.domain.usecases

import com.mavra.domain.BaseFlowUseCase
import com.mavra.domain.Repository
import com.mavra.domain.mapper.UIPhotoMapper
import com.mavra.domain.model.DomainResult
import com.mavra.nasaassignment.model.UIPhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

class FetchPhotoUseCase @Inject constructor(
    private val repository: Repository,
    private val uiPhotoMapper: UIPhotoMapper
) : BaseFlowUseCase<FetchPhotoUseCase.Request, FetchPhotoUseCase.Result>() {

    override fun execute(request: Request): Flow<DomainResult<Result>> = flow {
        val response = repository.fetchPhotos(
            request.roverType,
            request.camera
        )
        response.
        emit(Result(response))
    }

    data class Request(
        val roverType: String,
        val camera: String?
    )

    /**
     * Result wrapped because , it will Generate with live template
     */
    data class Result(
        val photos: List<UIPhoto> = listOf()
    )
}