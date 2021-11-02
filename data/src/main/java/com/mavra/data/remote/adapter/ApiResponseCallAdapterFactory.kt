package com.mavra.data.remote.adapter

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiResponseCallAdapterFactory @Inject constructor(
    private val moshi: Moshi
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (Call::class.java != getRawType(returnType)) {
            return null
        }
        check(returnType is ParameterizedType) {
            "return type must be parameterized as Call<ApiResponse<<Foo>> or Call<ApiResponse<out Foo>>"
        }
        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != Result::class.java) {
            return null
        }
        check(responseType is ParameterizedType) { "Response must be parameterized as NetworkResponse<Foo> or NetworkResponse<out Foo>" }

        val successBodyType = getParameterUpperBound(0, responseType)

        return ApiResponseCallAdapter<Any>(successBodyType)
    }

    inner class ApiResponseCallAdapter<T>(
        private val responseType: Type,
    ) : CallAdapter<T, Call<Result<T>>> {
        override fun responseType(): Type = responseType
        override fun adapt(call: Call<T>): Call<Result<T>> =
            ApiResponseCall(call, moshi)
    }

}