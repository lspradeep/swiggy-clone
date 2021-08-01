package com.android.compose.swiggyclone.di

import com.android.compose.swiggyclone.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response


class HttpNetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Authorization", BuildConfig.PEXELS_API_KEY)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}