package com.mavra.domain.mapper

import com.mavra.domain.model.DtoPhoto
import com.mavra.nasaassignment.model.UIPhoto
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */


@Singleton
class UIPhotoMapper @Inject constructor() : Mapper<DtoPhoto, UIPhoto> {
    override fun mapTo(out: DtoPhoto): UIPhoto = UIPhoto(
        out.imgSrc
    )
}