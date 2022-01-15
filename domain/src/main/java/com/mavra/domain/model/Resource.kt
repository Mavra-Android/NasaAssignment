package com.mavra.domain.model

/**
 * @user mustafa.kilic
 * @since 2.11.2021
 */

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Loading<T>(val isLoading: Boolean = false) : Resource<T>()
    data class Error<T>(val error: Throwable) : Resource<T>()
}