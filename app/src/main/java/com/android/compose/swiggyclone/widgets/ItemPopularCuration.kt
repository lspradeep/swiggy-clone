package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.white

@Composable
fun ItemPopularCuration(modifier: Modifier, curationName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(end = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_cooking),
            contentDescription = "",
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(color = white, shape = CircleShape.copy(CornerSize(25.dp))),
            contentScale = ContentScale.Crop
        )
        Text(
            text = curationName,
            style = Typography.subtitle1,
            maxLines = 2,
            modifier = modifier
                .padding(top = 8.dp)
                .width(80.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}