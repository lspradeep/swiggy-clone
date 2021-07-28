package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.ui.theme.*
import com.android.compose.swiggyclone.R

@Composable
fun ItemBannerTypeOne(modifier: Modifier) {
    Box(modifier.padding(start = 8.dp, end = 8.dp)) {
        Row(
            modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(brush = Brush.horizontalGradient(colors = pinkGradiant), alpha = 0.6f)

        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .weight(0.6f)
            ) {
                Text(
                    text = "up to 60% off try new tastes".uppercase(),
                    style = Typography.h6.copy(
                        color = brown,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "Fresh offers to enjoy\nnew dishes everyday.",
                    style = Typography.subtitle2.copy(
                        color = brown,
                    ),
                    modifier = modifier.padding(top = 8.dp, bottom = 8.dp)
                )

                Image(
                    imageVector = Icons.Rounded.NavigateNext,
                    contentDescription = "",
                    modifier = modifier
                        .background(shape = RoundedCornerShape(8.dp), color = white)
                        .padding(4.dp),
                )
            }

            Image(
                painter = painterResource(id = R.drawable.img_burger),
                contentDescription = "",
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.4f)
                    .fillMaxHeight(),
            )
        }
    }
}