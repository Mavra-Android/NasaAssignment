package com.mavra.data.mapper

import com.mavra.data.model.ApiResponse
import com.mavra.data.model.Photo
import com.mavra.data.model.Photos
import com.mavra.domain.model.DomainResult
import com.mavra.domain.model.DtoPhoto
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DomainResultPhotoMapper @Inject constructor(
    private val dtoPhotoMapper: DtoPhotoMapper
) : Mapper<ApiResponse<Photos>, DomainResult<List<DtoPhoto>>> {
    override fun mapTo(out: ApiResponse<Photos>): DomainResult<List<DtoPhoto>> {
        return when (out) {
            is ApiResponse.Error -> DomainResult.Error(out.error)
            is ApiResponse.Success -> DomainResult.Success(out.data.photos.map { dtoPhotoMapper.mapTo(it) })
        }
    }
}