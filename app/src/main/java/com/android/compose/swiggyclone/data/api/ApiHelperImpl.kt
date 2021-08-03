package com.android.compose.swiggyclone.data.api

import com.android.compose.swiggyclone.data.models.BaseResponse
import com.android.compose.swiggyclone.data.models.photo.Photo
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun getImages(
        pageNo: Int,
        perPage: Int,
        query: String
    ): BaseResponse<List<Photo>> {
        return apiService.getImages(pageNo, perPage, query)
    }
}