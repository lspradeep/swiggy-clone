package com.android.compose.swiggyclone.data.api

import com.android.compose.swiggyclone.data.models.BaseResponse
import com.android.compose.swiggyclone.data.models.Photo
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getPhotos(query: String): BaseResponse<List<Photo>> =
        apiService.getImages(query)
}