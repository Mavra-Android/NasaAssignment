package com.mavra.domain.model

sealed class DomainResult<T> {
    data class Success<T>(val data: T) : DomainResult<T>()
    data class Loading<T>(val isLoading: Boolean) : DomainResult<T>()
    data class Error<T>(val error: Throwable) : DomainResult<T>()
}