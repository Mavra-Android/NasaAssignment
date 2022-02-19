package com.mavra.data.mapper

import com.mavra.data.model.PhotoResponse
import com.mavra.domain.model.DomainPhotoDetail
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DomainPhotoDetailMapper @Inject constructor(
) : Mapper<PhotoResponse, DomainPhotoDetail> {
    override fun mapTo(out: PhotoResponse): DomainPhotoDetail =
        DomainPhotoDetail(
            imageId = out.id,
            date = out.earthDate,
            imagePath = out.imgSrc,
            cameraName = out.camera?.name.orEmpty(),
            roverName = out.rover?.name.orEmpty(),
            landingDate = out.rover?.landingDate.orEmpty(),
            launchDate = out.rover?.launchDate.orEmpty()
        )
}