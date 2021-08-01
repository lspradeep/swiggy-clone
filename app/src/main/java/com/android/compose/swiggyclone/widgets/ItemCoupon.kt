package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.grey
import com.android.compose.swiggyclone.ui.theme.white

@Composable
fun ItemCoupon(
    modifier: Modifier,
    icon: ImageVector,
    tint: Color,
    smallText: String,
    largeText: String
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .width(180.dp)
            .height(210.dp)
            .border(width = 1.dp, color = grey),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = white,
                modifier = modifier
                    .background(
                        shape = CircleShape.copy(all = CornerSize(percent = 25)),
                        color = tint
                    )
                    .padding(16.dp)
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = smallText.uppercase(),
                style = Typography.caption.copy(color = tint, fontWeight = FontWeight.ExtraBold),
                maxLines = 1
            )
            Spacer(modifier = modifier.height(8.dp))
            Text(
                text = largeText.uppercase(),
                style = Typography.subtitle1.copy(color = tint, fontWeight = FontWeight.ExtraBold),
                maxLines = 2,
                modifier = modifier
            )
        }
    }
}