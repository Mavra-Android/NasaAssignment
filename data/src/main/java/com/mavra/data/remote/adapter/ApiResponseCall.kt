package com.mavra.data.remote.adapter

import android.accounts.NetworkErrorException
import com.mavra.data.model.BaseApiError
import com.mavra.data.remote.throwables.ApiThrowable
import com.mavra.data.remote.throwables.UnauthorizedThrowable
import com.squareup.moshi.Moshi
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection

class ApiResponseCall<T>(
    private val delegate: Call<T>,
    private val moshi: Moshi,
) : Call<Result<T>> {

    override fun enqueue(callback: Callback<Result<T>>) {
        return delegate.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()
                if (response.isSuccessful) {
                    onSuccess(callback, body)
                } else {
                    onError(callback, error, code)
                }
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                val networkResponse = when (throwable) {
                    is IOException -> Result.failure<T>(NetworkErrorException())
                    else -> Result.failure(throwable)
                }
                callback.onResponse(
                    this@ApiResponseCall,
                    Response.success(networkResponse)
                )
            }
        })
    }


    private fun onSuccess(callback: Callback<Result<T>>, body: T?) {
        if (body != null) {
            callback.onResponse(
                this,
                Response.success(Result.success(body))
            )
        } else {
            callback.onResponse(
                this,
                Response.success(Result.success(true as T))
            )
        }
    }

    private fun onError(callback: Callback<Result<T>>, error: ResponseBody?, code: Int) {
        val errorBody = tryConvertErrorBody(error)
        val throwable = when {
            errorBody != null -> ApiThrowable(errorBody.error, code)
            code == HttpURLConnection.HTTP_NOT_AUTHORITATIVE -> UnauthorizedThrowable()
            else -> IllegalStateException()
        }
        callback.onResponse(this, Response.success(Result.failure(throwable)))
    }

    private fun tryConvertErrorBody(error: ResponseBody?): BaseApiError? {
        return when {
            error == null -> null
            error.contentLength() == 0L -> null
            else -> try {
                moshi.adapter(BaseApiError::class.java).fromJson(error.string())
            } catch (ex: Exception) {
                null
            }
        }

    }

    override fun isExecuted() = delegate.isExecuted
    override fun clone() = ApiResponseCall(delegate.clone(), moshi)
    override fun isCanceled() = delegate.isCanceled
    override fun cancel() = delegate.cancel()
    override fun request(): Request = delegate.request()
    override fun timeout(): Timeout = delegate.timeout()
    override fun execute(): Response<Result<T>> =
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")

}