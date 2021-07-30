package com.android.compose.swiggyclone.data.models

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("photographer")
    val photographer: String,
    @SerializedName("photographer_url")
    val photographerUrl: String,
    @SerializedName("photographer_id")
    val photographerId: Int,
    @SerializedName("avg_color")
    val avgColor: String,
    @SerializedName("src")
    val source: Source,
    @SerializedName("liked")
    val liked: Boolean,
)
