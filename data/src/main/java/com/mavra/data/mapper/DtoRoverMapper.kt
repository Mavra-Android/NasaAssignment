package com.mavra.data.mapper

import com.mavra.data.model.Rover
import com.mavra.domain.model.DtoRover
import com.mavra.shared.Mapper
import javax.inject.Inject

class DtoRoverMapper @Inject constructor() : Mapper<Rover, DtoRover> {
    override fun mapTo(out: Rover): DtoRover =
        DtoRover(
            name = out.name,
            landingDate = out.landingDate,
            launchDate = out.launchDate,
            status = out.status
        )
}