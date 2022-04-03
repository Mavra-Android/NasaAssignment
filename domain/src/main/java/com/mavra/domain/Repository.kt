package com.mavra.domain

import com.mavra.domain.model.DomainPhoto
import com.mavra.domain.model.DomainPhotoDetail

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
interface Repository {

    suspend fun fetchPhotos(roverType: String, camera: String? = null): List<DomainPhoto>

    suspend fun fetchPhotoDetail(roverType: String, id: String, camera: String? = null): DomainPhotoDetail
}