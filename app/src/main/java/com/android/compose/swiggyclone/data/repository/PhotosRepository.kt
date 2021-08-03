package com.android.compose.swiggyclone.data.repository

import com.android.compose.swiggyclone.data.api.ApiHelper
import com.android.compose.swiggyclone.data.models.BaseResponse
import com.android.compose.swiggyclone.data.models.photo.Photo
import javax.inject.Inject


class PhotosRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getPhotos(
        pageNo: Int,
        perPage: Int,
        query: String
    ): BaseResponse<List<Photo>> {
        return apiHelper.getImages(pageNo, perPage, query)
    }
}