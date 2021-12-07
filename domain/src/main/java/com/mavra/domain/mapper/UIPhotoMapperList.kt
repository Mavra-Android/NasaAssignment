package com.mavra.domain.mapper

import com.mavra.data.model.Photo
import com.mavra.domain.model.UIPhoto
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIPhotoMapperList @Inject constructor(
) : Mapper<Photo, UIPhoto> {
    override fun mapTo(out: Photo): UIPhoto = UIPhoto(out.imgSrc)
}