package com.mavra.data.remote

import com.mavra.data.mapper.DomainResultPhotoMapper
import javax.inject.Inject

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
class RemoteDataSource @Inject constructor(
    private val nasaService: NasaService,
    private val domainResultPhotoMapper: DomainResultPhotoMapper
) {
    suspend fun fetchPhotos(roverType: String, camera: String? = null) =
        domainResultPhotoMapper.mapTo(nasaService.fetchPhotos(roverType, camera = camera))
}