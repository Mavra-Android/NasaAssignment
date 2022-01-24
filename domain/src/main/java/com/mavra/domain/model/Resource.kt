package com.mavra.domain.model

/**
 * @user mustafa.kilic
 * @since 2.11.2021
 */

sealed class Resource<T> constructor(open val status: Status?) {
    data class Success<T>(override val status: Status? = Status.SUCCESS, val data: T) : Resource<T>(status)
    data class Loading<T>(override val status: Status? = Status.LOADING) : Resource<T>(status)
    data class Error<T>(override val status: Status? = Status.ERROR, val error: Throwable) : Resource<T>(status)

    enum class Status{
        SUCCESS,
        LOADING,
        ERROR
    }
}