package com.mavra.data.di

import com.mavra.data.RepositoryImp
import com.mavra.data.mapper.DomainPhotoMapper
import com.mavra.data.remote.NasaService
import com.mavra.data.remote.RemoteDataSource
import com.mavra.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

/**
 * @user mustafa.kilic
 * @since 30.10.2021
 */

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        domainPhotoMapper: DomainPhotoMapper
    ):Repository = RepositoryImp(remoteDataSource,domainPhotoMapper)

}