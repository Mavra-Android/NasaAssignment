package com.mavra.data.model

import com.squareup.moshi.Json

data class Camera(
    val id: String,
    val name: String,
    @Json(name = "rover_id")
    val roverId: String,
    @Json(name = "full_name")
    val fullName: String
)