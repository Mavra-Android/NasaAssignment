package com.mavra.domain

import com.mavra.data.model.Photo

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
interface Repository {

    suspend fun fetchPhotos(roverType: String, camera: String? = null): List<Photo>
}