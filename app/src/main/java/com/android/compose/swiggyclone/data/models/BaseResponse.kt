package com.android.compose.swiggyclone.data.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("photos")
    val data:T? = null,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("next_page")
    val nextPage: String,
)
