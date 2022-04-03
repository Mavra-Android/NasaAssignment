package com.mavra.data.model

import com.squareup.moshi.Json

data class PhotoResponse(
    val id: String,
    val sol: Long,
    val camera: CameraResponse? = null,
    val rover: RoverResponse? = null,
    @Json(name = "earth_date")
    val earthDate: String,
    @Json(name = "img_src")
    val imgSrc: String,
)

