package com.mavra.data

import com.mavra.data.mapper.DomainPhotoDetailMapper
import com.mavra.data.mapper.DomainPhotoMapper
import com.mavra.data.model.PhotoResponse
import com.mavra.data.remote.RemoteDataSource
import com.mavra.domain.Repository
import com.mavra.domain.model.DomainPhoto
import com.mavra.domain.model.DomainPhotoDetail
import java.lang.NullPointerException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */
class RepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val domainPhotoMapper: DomainPhotoMapper,
    private val domainPhotoDetailMapper: DomainPhotoDetailMapper
) : Repository {

    override suspend fun fetchPhotos(
        roverType: String,
        camera: String?
    ): List<DomainPhoto> =
        remoteDataSource.fetchPhotos(roverType, camera).map { domainPhotoMapper.mapTo(it) }

    override suspend fun fetchPhotoDetail(
        roverType: String,
        id: String,
        camera: String?
    ): DomainPhotoDetail {
        val response = remoteDataSource.fetchPhotoDetail(
            roverType = roverType,
            id = id,
            camera = camera
        )
        return domainPhotoDetailMapper.mapTo(response ?: throw NullPointerException())
    }

}