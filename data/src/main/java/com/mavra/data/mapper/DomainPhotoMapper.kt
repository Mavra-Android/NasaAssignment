package com.mavra.data.mapper

import com.mavra.data.model.PhotoResponse
import com.mavra.domain.model.DomainPhoto
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DomainPhotoMapper @Inject constructor(
) : Mapper<PhotoResponse, DomainPhoto> {
    override fun mapTo(out: PhotoResponse): DomainPhoto = DomainPhoto(out.id,out.earthDate,out.imgSrc)
}