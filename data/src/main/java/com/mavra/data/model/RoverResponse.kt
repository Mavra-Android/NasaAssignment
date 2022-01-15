package com.mavra.data.model

import com.squareup.moshi.Json

data class RoverResponse(
    val id: String,
    val name: String,
    val status: String,
    @Json(name = "landing_date")
    val landingDate: String,
    @Json(name = "launch_date")
    val launchDate: String
)