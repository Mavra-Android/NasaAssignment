package com.mavra.data.di

import com.mavra.data.RepositoryImp
import com.mavra.data.remote.RemoteDataSource
import com.mavra.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource
    ) = RepositoryImp(remoteDataSource) as Repository

}