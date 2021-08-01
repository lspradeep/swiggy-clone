package com.android.compose.swiggyclone.di

import com.android.compose.swiggyclone.BuildConfig
import com.android.compose.swiggyclone.data.api.ApiHelper
import com.android.compose.swiggyclone.data.api.ApiHelperImpl
import com.android.compose.swiggyclone.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL_IMG

    @Provides
    @Singleton
    fun provideOkHttpClient(httpNetworkInterceptor: HttpNetworkInterceptor) =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(httpNetworkInterceptor)
                .build()
        } else OkHttpClient
            .Builder()
            .addInterceptor(httpNetworkInterceptor)
            .build()

    @Provides
    @Singleton
    fun providesNetworkInterceptor(): HttpNetworkInterceptor = HttpNetworkInterceptor()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}