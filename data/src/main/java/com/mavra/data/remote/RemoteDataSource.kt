package com.mavra.data.remote

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

@Singleton
class RemoteDataSource @Inject constructor(
    private val nasaService: NasaService,
) {

    suspend fun fetchPhotos(roverType: String, camera: String? = null) =
        nasaService.fetchPhotos(roverType, camera = camera).getOrThrow()
            .photos

    suspend fun fetchPhotoDetail(roverType: String, id: String, camera: String?) =
        nasaService.fetchPhotos(roverType = roverType, camera = camera).getOrThrow()
            .photos
            .find { it.id == id }
}