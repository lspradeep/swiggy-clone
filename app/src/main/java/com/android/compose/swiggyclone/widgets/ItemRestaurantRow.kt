package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.data.models.restaurant.Restaurant
import com.android.compose.swiggyclone.features.nav.Routes
import com.android.compose.swiggyclone.ui.theme.*
import com.android.compose.swiggyclone.utils.Constants.CURRENCY_SYMBOL


@Composable
fun ItemRestaurantRow(
    modifier: Modifier,
    restaurants: List<Restaurant>,
    navController: NavController
) {
    Column(modifier = modifier.clickable {
        navController.navigate(Routes.RESTAURANT_DETAIL.routeName)
    }) {
        restaurants.forEach { restaurant ->
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                ConstraintLayout {
                    val (imgId, offerText) = createRefs()

                    Image(
                        rememberImagePainter(restaurant.image),
                        contentDescription = "",
                        modifier = modifier
                            .constrainAs(imgId) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .size(80.dp)
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "${restaurant.offerPercentage}% off".uppercase(),
                        modifier = modifier
                            .constrainAs(offerText) {
                                top.linkTo(parent.bottom)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .background(color = white, shape = RoundedCornerShape(4.dp))
                            .border(
                                width = 1.dp,
                                color = greyLight,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(2.dp),
                        style = Typography.caption.copy(
                            fontWeight = FontWeight.Bold,
                            color = secondaryVariant
                        )
                    )
                }

                HorizontalSpace(modifier = modifier)

                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = restaurant.name, style = Typography.body2)

                    Text(
                        text = restaurant.cuisines,
                        style = Typography.caption
                    )

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

                    Divider(
                        modifier = modifier
                            .weight(1f)
                            .height(1.dp)
                    )

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