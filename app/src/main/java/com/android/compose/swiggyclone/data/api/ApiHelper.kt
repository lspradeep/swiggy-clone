package com.android.compose.swiggyclone.data.api

import com.android.compose.swiggyclone.data.models.BaseResponse
import com.android.compose.swiggyclone.data.models.Photo

interface ApiHelper {
    suspend fun getPhotos(query: String): BaseResponse<List<Photo>>
}