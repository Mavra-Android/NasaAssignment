package com.mavra.domain.usecases

import com.mavra.domain.BaseFlowUseCase
import com.mavra.domain.Repository
import com.mavra.domain.model.DomainPhotoDetail
import com.mavra.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class FetchPhotoDetailUseCase @Inject constructor(
    private val repository: Repository
) : BaseFlowUseCase<FetchPhotoDetailUseCase.Request, DomainPhotoDetail>() {

    override fun execute(request: Request): Flow<Resource<DomainPhotoDetail>> =
        flow {
            val response = repository.fetchPhotoDetail(
                roverType = request.roverType,
                id = request.id
            )
            emit(Resource.Success(data = response))
        }

    data class Request(
        val roverType: String,
        val id: String
    )


}
