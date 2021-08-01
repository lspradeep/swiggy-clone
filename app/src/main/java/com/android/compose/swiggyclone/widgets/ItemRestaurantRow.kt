package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.data.local.Restaurant
import com.android.compose.swiggyclone.ui.theme.*
import com.android.compose.swiggyclone.utils.Constants.CURRENCY_SYMBOL


@Composable
fun ItemRestaurantRow(
    modifier: Modifier,
    restaurants: List<Restaurant>,
    imageUrls: List<String?>
) {
    Column {
        restaurants.forEachIndexed { index, restaurant ->
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Box {
                    Image(
                        rememberImagePainter(imageUrls[index]),
                        contentDescription = "",
                        modifier = modifier
                            .size(80.dp)
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "${restaurant.offerPercentage}% off".uppercase(),
                        modifier = modifier
                            .background(color = white, shape = RoundedCornerShape(4.dp))
                            .border(
                                width = 1.dp,
                                color = greyLight,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(2.dp)
                            .align(Alignment.BottomCenter),
                        style = Typography.caption.copy(
                            fontWeight = FontWeight.Bold,
                            color = secondaryVariant
                        )
                    )
                }

                HorizontalSpace(modifier = modifier)

                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = restaurant.name, style = Typography.body2)

                    Text(
                        text = "${restaurant.place} | ${restaurant.kilometersAway}",
                        style = Typography.caption
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            modifier = modifier.size(18.dp)
                        )
                        HorizontalSpace(modifier = modifier)
                        Text(
                            text = "${restaurant.rating} . ${restaurant.deliveryTime} . ${CURRENCY_SYMBOL}${restaurant.costForTwo} for two",
                            style = Typography.caption.copy(fontWeight = FontWeight.ExtraBold)
                        )
                    }

                    Divider(modifier = modifier.fillMaxWidth(), color = greyDark)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_discount),
                            contentDescription = "",
                            tint = secondaryColor,
                            modifier = modifier.size(18.dp)
                        )
                        HorizontalSpace(modifier = modifier)
                        Text(
                            text = "${restaurant.offerPercentage}% off",
                            style = Typography.caption
                        )

                    }

                }

            }
        }
    }
}