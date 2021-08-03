package com.android.compose.swiggyclone.data.models.coupon

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