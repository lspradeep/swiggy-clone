package com.android.compose.swiggyclone.data.models.restaurant

data class Restaurant(
    val name: String,
    val image:String?,
    val cuisines: String,
    val deliveryTime: String,
    val place: String,
    val kilometersAway: String,
    val offerPercentage: Int,
    val costForTwo: Int,
    val rating: Float
)