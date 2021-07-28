package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.grey

@Composable
fun ItemServiceType(
    modifier: Modifier,
    serviceName: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(end = 10.dp)
    ) {
        Box(
            modifier = modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .border(
                    shape = CircleShape.copy(all = CornerSize(16.dp)),
                    border = BorderStroke(1.dp, color = grey)
                )
                .width(100.dp)
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_service_type_placeholder),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.clip(shape = RoundedCornerShape(16.dp))
            )

            Text(
                text = serviceName,
                style = Typography.body2.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }
        Text(
            text = description,
            modifier = modifier
                .padding(8.dp)
                .width(90.dp),
            textAlign = TextAlign.Center,
            style = Typography.caption,
            maxLines = 2
        )
    }
}