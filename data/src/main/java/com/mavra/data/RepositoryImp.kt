package com.mavra.data

import com.mavra.data.model.Photo
import com.mavra.data.remote.RemoteDataSource
import com.mavra.domain.Repository

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
    ): List<Photo> = remoteDataSource.fetchPhotos(roverType, camera)
}