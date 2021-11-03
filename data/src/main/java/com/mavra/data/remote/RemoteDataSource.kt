package com.mavra.data.remote

import com.mavra.data.mapper.DtoPhotoMapper
import javax.inject.Inject

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
class RemoteDataSource @Inject constructor(
    private val nasaService: NasaService,
    private val photoMapper: DtoPhotoMapper
) {

    suspend fun fetchPhotos(roverType: String, camera: String? = null) =
        nasaService.fetchPhotos(roverType, camera = camera).getOrThrow()
            .photos.map { photoMapper.mapTo(it) }


}