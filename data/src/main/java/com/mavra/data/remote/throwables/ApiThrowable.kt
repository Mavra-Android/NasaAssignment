package com.mavra.data.remote.throwables

import com.mavra.data.model.ApiError

data class ApiThrowable(
    val body: ApiError,
    val code: Int
) : Throwable()
