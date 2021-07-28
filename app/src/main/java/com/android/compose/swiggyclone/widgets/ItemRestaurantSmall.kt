package com.android.compose.swiggyclone.widgets

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.greyLight
import com.android.compose.swiggyclone.ui.theme.secondaryVariant
import com.android.compose.swiggyclone.ui.theme.white

//restaurantDetails Triple(restaurant name, delivery time, offer(int percent))
@Composable
fun ItemRestaurantSmall(
    modifier: Modifier,
    restaurant: Triple<String, String, Int>
) {
    Box(modifier = modifier.padding(8.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.img_food_placeholder),
                    contentDescription = "",
                    modifier = modifier
                        .size(60.dp, 60.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "${restaurant.third}% off".uppercase(),
                    modifier = modifier
                        .background(color = white, shape = RoundedCornerShape(4.dp))
                        .border(width = 1.dp, color = greyLight, shape = RoundedCornerShape(4.dp))
                        .padding(2.dp)
                        .align(Alignment.BottomCenter),
                    style = Typography.caption.copy(
                        fontWeight = FontWeight.Bold,
                        color = secondaryVariant
                    )
                )
            }

            Text(
                text = restaurant.first, modifier = modifier
                    .padding(top = 4.dp)
                    .width(60.dp),
                style = Typography.caption.copy(fontWeight = FontWeight.Bold), maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = restaurant.second, modifier = modifier
                    .padding(top = 4.dp)
                    .width(60.dp)
                    .align(alignment = Alignment.Start),
                style = Typography.caption, maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

    }

}