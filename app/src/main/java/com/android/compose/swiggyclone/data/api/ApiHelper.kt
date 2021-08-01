package com.android.compose.swiggyclone.data.api

import com.android.compose.swiggyclone.data.models.BaseResponse
import com.android.compose.swiggyclone.data.models.Photo
import retrofit2.http.Query

interface ApiHelper {
    suspend fun getImages(
        pageNo: Int,
        perPage: Int,
        query: String
    ): BaseResponse<List<Photo>>
}