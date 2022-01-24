package com.mavra.domain

import com.mavra.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */


abstract class BaseFlowUseCase<in In, Out> {
    abstract fun execute(request: In): Flow<Resource<Out>>

    open fun invoke(request: In) = execute(request)
        .onStart {
            emit(Resource.Loading())
        }
        .catch { t ->
            emit(Resource.Error(error = t))
        }
}

