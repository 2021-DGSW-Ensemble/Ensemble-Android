package org.dgsw.ensemble.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.dgsw.ensemble.model.datasource.remote.VideoService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    private val URL = "192.168.0.26"

    @Provides
    @Singleton
    fun provideVideoService(): VideoService =
        Retrofit.Builder()
            .baseUrl(URL)
            .build()
            .create(VideoService::class.java)


}