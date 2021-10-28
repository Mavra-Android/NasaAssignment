package com.mavra.data

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @user mustafa.kilic
 * @since 28.10.2021
 */


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{


    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        moshi: Moshi
    ) = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory()
        .build()

}
