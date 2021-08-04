package com.android.compose.swiggyclone.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.features.ResourceStatus
import com.android.compose.swiggyclone.ui.theme.secondaryColor
import com.android.compose.swiggyclone.widgets.*

@Composable
fun HomeScreen(modifier: Modifier, mainViewModel: MainViewModel) {
    val images by mainViewModel.imagesData.observeAsState()
    val serviceTypes by mainViewModel.serviceTypes.observeAsState()
    val allRestaurants by mainViewModel.allRestaurants.observeAsState()
    val restaurantsYouLove by mainViewModel.restaurantsYouLove.observeAsState()
    val inTheSpotlight by mainViewModel.inTheSpotlight.observeAsState()
    val trySomethingNew by mainViewModel.trySomethingNew.observeAsState()
    val topOffers by mainViewModel.topOffers.observeAsState()
    val curations by mainViewModel.curations.observeAsState()
    val coupons by mainViewModel.coupons.observeAsState()

    if ((images?.data != null && images?.resourceStatus == ResourceStatus.SUCCESS)) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 8.dp,
                end = 8.dp,
                top = 8.dp,
                bottom = 100.dp
            ),
        ) {
            item {
                VerticalSpace(modifier = modifier)

                LazyRow {
                    item {
                        serviceTypes?.map { service ->
                            ItemServiceType(
                                modifier = modifier,
                                serviceName = service.serviceName,
                                description = service.description,
                                imageUrl = service.image
                            )
                        }
                    }
                }//end service type

                VerticalSpace(modifier = modifier)

                ItemBannerTypeOne(modifier = modifier)

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(
                    modifier = modifier,
                    leadIcon = Icons.Default.Favorite,
                    title = "Restaurants You love"
                )

                VerticalSpace(modifier = modifier)

                //restaurants
                LazyRow {
                    item {
                        restaurantsYouLove?.forEach { restaurant ->
                            ItemRestaurantSmall(
                                modifier = modifier,
                                restaurant = restaurant
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(modifier = modifier, title = "Popular Curations")

                VerticalSpace(modifier = modifier)

                LazyRow {
                    item {
                        curations?.forEach { curation ->
                            ItemPopularCuration(
                                modifier = modifier,
                                curationName = curation.name,
                                imageUrl = curation.image
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(
                    modifier = modifier,
                    leadIcon = Icons.Default.Lightbulb,
                    title = "In the Spotlight!"
                )

                VerticalSpace(modifier = modifier)

                //restaurants
                LazyRow(modifier = modifier.fillMaxWidth()) {
                    item {
                        inTheSpotlight?.chunked(2)?.forEach { restaurants ->
                            ItemRestaurantRow(
                                modifier = modifier,
                                restaurants = restaurants
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(
                    modifier = modifier,
                    title = "Coupons For You"
                )
                VerticalSpace(modifier = modifier)

                LazyRow {
                    item {
                        coupons?.forEach { coupon ->
                            ItemCoupon(
                                modifier = modifier,
                                icon = coupon.icon,
                                tint = coupon.tint,
                                smallText = coupon.smallText,
                                largeText = coupon.largeText
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(
                    modifier = modifier,
                    leadIcon = Icons.Default.Fastfood,
                    title = "Try Something New"
                )
                VerticalSpace(modifier = modifier)

                //restaurants
                LazyRow {
                    item {
                        trySomethingNew?.forEach { restaurant ->
                            ItemRestaurantSmall(
                                modifier = modifier,
                                restaurant = restaurant
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(
                    modifier = modifier,
                    leadIcon = Icons.Default.LocalOffer,
                    title = "Top Offers"
                )

                VerticalSpace(modifier = modifier)

                //restaurants
                LazyRow(modifier = modifier.fillMaxWidth()) {
                    item {
                        topOffers?.chunked(2)?.forEach { restaurants ->
                            ItemRestaurantRow(
                                modifier = modifier,
                                restaurants = restaurants
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(
                    modifier = modifier,
                    leadIcon = Icons.Default.FreeBreakfast,
                    title = "All Restaurants Nearby"
                )

                VerticalSpace(modifier = modifier)

                //restaurants
                allRestaurants?.chunked(1)?.forEach { restaurants ->
                    ItemRestaurantRow(
                        modifier = modifier,
                        restaurants = restaurants,
                    )
                }

                VerticalSpace(modifier = modifier)
            }
        }

    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = secondaryColor
            )
        }
    }
}