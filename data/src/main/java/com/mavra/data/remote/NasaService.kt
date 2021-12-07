package com.mavra.data.remote

import com.mavra.data.model.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @user mustafa.kilic
 * @since 28.10.2021
 */
interface NasaService {
    @GET("v1/rovers/{roverType}/photos/")
    suspend fun fetchPhotos(
        @Path("roverType") roverType: String,
        @Query("page") page: Int = 1,
        @Query("sol") sol: Int = 1000,
        @Query("camera") camera: String? = null,
    ): Result<PhotosResponse>
}





