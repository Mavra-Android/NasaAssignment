package com.mavra.data.model

sealed class ApiResponse<T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error<T>(val error: Throwable) : ApiResponse<T>()
}

