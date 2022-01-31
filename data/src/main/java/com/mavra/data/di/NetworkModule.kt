package com.mavra.data.di

import android.content.Context
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.mavra.data.BuildConfig
import com.mavra.data.adapters.*
import com.mavra.data.remote.NasaService
import com.mavra.data.remote.adapter.ApiResponseCallAdapterFactory
import com.mavra.data.remote.interceptors.AuthorizationInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideMoshi(
        jsonAdapterDouble: JsonAdapterDouble,
        jsonAdapterString: JsonAdapterString,
        jsonAdapterInt: JsonAdapterInt,
        jsonAdapterLong: JsonAdapterLong
    ): Moshi =
        Moshi.Builder()
            .add(Double::class.java, jsonAdapterDouble)
            .add(String::class.java, jsonAdapterString)
            .add(Int::class.java, jsonAdapterInt)
            .add(Long::class.java, jsonAdapterLong)
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        authorizationInterceptor: AuthorizationInterceptor
    ): OkHttpClient {
        val flipper = AndroidFlipperClient.getInstance(context)
        val networkPlugin = NetworkFlipperPlugin()
        flipper.addPlugin(InspectorFlipperPlugin(context, DescriptorMapping.withDefaults()))
        flipper.addPlugin(networkPlugin)
        flipper.start()
        return OkHttpClient.Builder()
            .addInterceptor(FlipperOkhttpInterceptor(networkPlugin))
            .addInterceptor(authorizationInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        moshi: Moshi,
        client: OkHttpClient,
        factory: ApiResponseCallAdapterFactory) =
            Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(client)
            .addCallAdapterFactory(factory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    fun provideRoverService(retrofit: Retrofit):NasaService =
        retrofit.create<NasaService>()
}
