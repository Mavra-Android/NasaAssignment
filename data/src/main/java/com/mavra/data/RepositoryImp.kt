package com.mavra.data

import com.mavra.data.remote.RemoteDataSource
import com.mavra.domain.Repository
import com.mavra.domain.model.DomainResult
import com.mavra.domain.model.DtoPhoto

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

class RepositoryImp(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun fetchPhotos(
        roverType: String,
        camera: String?
    ): DomainResult<List<DtoPhoto>> = remoteDataSource.fetchPhotos(roverType, camera)
}