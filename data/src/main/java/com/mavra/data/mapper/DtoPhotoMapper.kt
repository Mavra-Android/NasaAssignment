package com.mavra.data.mapper

import com.mavra.data.model.Photo
import com.mavra.domain.model.DtoPhoto
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DtoPhotoMapper @Inject constructor(
    private val dtoRoverMapper: DtoRoverMapper,
    private val dtoCameraMapper: DtoCameraMapper
) : Mapper<Photo, DtoPhoto> {
    override fun mapTo(out: Photo): DtoPhoto =
        DtoPhoto(
            imgSrc = out.imgSrc,
            id = out.id,
            earthDate = out.earthDate,
            rover = out.rover?.let { dtoRoverMapper.mapTo(it) },
            camera = out.camera?.let { dtoCameraMapper.mapTo(out.camera) }
        )
}


