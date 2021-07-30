package com.android.compose.swiggyclone.di

import com.android.compose.swiggyclone.BuildConfig
import com.android.compose.swiggyclone.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object AppModule {
    @Provides
    fun providesService(
        // Potential dependencies of this type
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_IMG)
            .build()
            .create(ApiService::class.java)
    }
}