package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.ui.theme.greyLight

@Composable
fun OfferBannerTypeOne(modifier: Modifier) {
    Box(modifier.padding(8.dp)) {
        Box(
            modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.Blue)

        ) {

        }
    }
}