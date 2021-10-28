package com.mavra.data.model

import com.squareup.moshi.Json

data class Photo(
    val id: String,
    val sol: Long,
    val camera: Camera? = null,
    val rover: Rover? = null,
    @Json(name = "earth_date")
    val earthDate: String,
    @Json(name = "img_src")
    val imgSrc: String,
)

