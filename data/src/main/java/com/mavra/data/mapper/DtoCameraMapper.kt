package com.mavra.data.mapper

import com.mavra.data.model.Camera
import com.mavra.domain.model.DtoCamera
import com.mavra.shared.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DtoCameraMapper @Inject constructor() : Mapper<Camera, DtoCamera> {
    override fun mapTo(out: Camera): DtoCamera =
        DtoCamera(
            out.fullName
        )
}


