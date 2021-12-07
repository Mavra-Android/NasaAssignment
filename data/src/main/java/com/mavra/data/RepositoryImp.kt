package com.mavra.data

import com.mavra.data.mapper.DomainPhotoMapper
import com.mavra.data.model.PhotoResponse
import com.mavra.data.remote.RemoteDataSource
import com.mavra.domain.Repository
import com.mavra.domain.model.DomainPhoto

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

class RepositoryImp(
    private val remoteDataSource: RemoteDataSource,
    private val domainPhotoMapper: DomainPhotoMapper
) : Repository {

    override suspend fun fetchPhotos(
        roverType: String,
        camera: String?
    ): List<DomainPhoto> = remoteDataSource.fetchPhotos(roverType, camera).map { domainPhotoMapper.mapTo(it) }
}