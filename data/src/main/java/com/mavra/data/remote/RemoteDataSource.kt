package com.mavra.data.remote

import javax.inject.Inject

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
class RemoteDataSource @Inject constructor(
    private val nasaService: NasaService) {

    suspend fun fetchPhotos(roverType: String, camera: String? = null) =
        nasaService.fetchPhotos(roverType, camera = camera).getOrThrow()
            .photos


}