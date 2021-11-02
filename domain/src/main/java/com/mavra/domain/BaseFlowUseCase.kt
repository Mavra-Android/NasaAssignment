package com.mavra.domain

import com.mavra.domain.model.DomainResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */


abstract class BaseFlowUseCase<in In, Out> {
    protected abstract fun execute(request: In): Flow<DomainResult<Out>>

    open fun invoke(request: In) = execute(request)
        .onStart {
            emit(DomainResult.Loading(true))
        }
        .onCompletion {
            emit(DomainResult.Loading(false))
        }
        .catch { t ->
            emit(DomainResult.Error(t))
        }
}