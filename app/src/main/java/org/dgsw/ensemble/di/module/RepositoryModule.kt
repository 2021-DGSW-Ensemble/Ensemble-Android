package org.dgsw.ensemble.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.dgsw.ensemble.model.repository.MemoryVideoRepository
import org.dgsw.ensemble.model.repository.RemoteVideoRepository
import org.dgsw.ensemble.model.repository.abstraction.VideoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVideoRepository(videoRepository: RemoteVideoRepository): VideoRepository

}