package com.mavra.domain

import com.mavra.domain.model.DomainResult
import com.mavra.domain.model.DtoPhoto

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
interface Repository {

    suspend fun fetchPhotos(roverType: String, camera: String? = null): DomainResult<List<DtoPhoto>>
}