package com.android.compose.swiggyclone.widgets

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.android.compose.swiggyclone.features.main.MainViewModel
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.greyLight
import com.android.compose.swiggyclone.ui.theme.secondaryVariant
import com.android.compose.swiggyclone.ui.theme.white

//restaurantDetails Triple(restaurant name, delivery time, offer(int percent))
@Composable
fun ItemRestaurantSmall(
    modifier: Modifier,
    restaurant: Triple<String, String, Int>,
    imageUrl: String?
) {
    val context = LocalContext.current
    val itemMaxWidth = 65.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(end = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            Image(
                rememberImagePainter(imageUrl),
                contentDescription = "",
                modifier = modifier
                    .size(itemMaxWidth, itemMaxWidth)
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
                .width(itemMaxWidth)
                .align(alignment = Alignment.CenterHorizontally),
            style = Typography.caption.copy(fontWeight = FontWeight.Bold), maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = restaurant.second, modifier = modifier
                .padding(top = 4.dp)
                .width(itemMaxWidth)
                .align(alignment = Alignment.Start),
            style = Typography.caption, maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}