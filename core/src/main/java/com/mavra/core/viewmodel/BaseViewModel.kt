package com.mavra.core.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mavra.domain.model.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModel : ViewModel() {
    inline fun <T> Flow<Resource<T>>.dataHandling(
        isShowError: Boolean = false,
        isShowLoading: Boolean = false,
        crossinline success:(data:T) -> Unit,
        crossinline showLoading: () -> Unit = {},
        crossinline showError: () -> Unit = {}
    ): Job {
        return this.onEach {
            when (it) {
                is Resource.Success -> {
                    success.invoke(it.data)
                }
                is Resource.Loading -> {
                    showLoading.invoke()
                }
                is Resource.Error -> {
                    showError.invoke()
                }
            }
        }.launchIn(viewModelScope)
    }

}