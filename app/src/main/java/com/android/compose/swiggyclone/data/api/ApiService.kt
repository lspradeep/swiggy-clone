package com.android.compose.swiggyclone.data.api

import com.android.compose.swiggyclone.data.models.BaseResponse
import com.android.compose.swiggyclone.data.models.photo.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun getImages(
        @Query("page") pageNo: Int,
        @Query("per_page") perPage: Int,
        @Query("query") query: String
    ): BaseResponse<List<Photo>>
}