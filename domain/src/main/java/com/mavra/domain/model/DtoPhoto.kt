package com.mavra.domain.model

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

data class DtoPhoto(
    val imgSrc: String,
    val id: String,
    val earthDate: String,
    val rover: DtoRover?,
    val camera: DtoCamera?
)