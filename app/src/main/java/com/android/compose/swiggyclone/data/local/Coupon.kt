package com.android.compose.swiggyclone.data.local

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.ui.theme.couponColor1
import com.android.compose.swiggyclone.ui.theme.couponColor2
import com.android.compose.swiggyclone.ui.theme.couponColor3

data class Coupon(
    val icon: ImageVector,
    val tint: Color,
    val smallText: String,
    val largeText: String
)

val couponData = listOf(
    Coupon(
        icon = Icons.Default.Fastfood,
        tint = couponColor1,
        smallText = "-Try New-",
        largeText = "up to 60% off",
    ),
    Coupon(
        icon = Icons.Default.FoodBank,
        tint = couponColor2,
        smallText = "-Welcome back-",
        largeText = "Missed you",
    ),
    Coupon(
        icon = Icons.Default.NoFood,
        tint = couponColor3,
        smallText = "-Unlimited-",
        largeText = "Large discounts",
    ),
    Coupon(
        icon = Icons.Default.EmojiFoodBeverage,
        tint = couponColor1,
        smallText = "Try New",
        largeText = "up to 60% off",
    ),
    Coupon(
        icon = Icons.Default.NoFood,
        tint = couponColor2,
        smallText = "Try New",
        largeText = "up to 60% off",
    )
)