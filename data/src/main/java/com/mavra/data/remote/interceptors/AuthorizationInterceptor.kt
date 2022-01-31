package com.mavra.data.remote.interceptors

import com.mavra.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @user mustafa.kilic
 * @since 28.10.2021
 */

@Singleton
class AuthorizationInterceptor @Inject constructor() : Interceptor {
    companion object {
        const val QUERY_API_KEY = "api_key"
    }
    override fun intercept(chain: Interceptor.Chain): Response =
        with(chain.request()) {
            val url = url.newBuilder()
                .addQueryParameter(QUERY_API_KEY, BuildConfig.API_KEY)
                .build()
            chain.proceed(newBuilder().url(url).build())
        }

}
