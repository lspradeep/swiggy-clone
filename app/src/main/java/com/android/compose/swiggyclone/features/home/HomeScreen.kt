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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.compose.swiggyclone.data.local.couponData
import com.android.compose.swiggyclone.data.local.restaurantData
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.features.ResourceStatus
import com.android.compose.swiggyclone.ui.theme.secondaryColor
import com.android.compose.swiggyclone.widgets.*

@Composable
fun HomeScreen(modifier: Modifier, mainViewModel: MainViewModel) {
    val images by mainViewModel.imagesData.observeAsState()
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
                        listOf(
                            "Restaurant",
                            "Health Hub",
                            "Care Corner",
                            "Restaurant",
                            "Health Hub",
                            "Care Corner"
                        ).map { serviceName ->
                            ItemServiceType(
                                modifier = modifier,
                                serviceName = serviceName,
                                description = "Enjoy Your favourite treats",
                                mainViewModel.getRandomMediumImage()
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
                        restaurantData.forEach { restaurant ->
                            ItemRestaurantSmall(
                                modifier = modifier,
                                restaurant = restaurant,
                                imageUrl = mainViewModel.getRandomTinyImage()
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                ItemSectionTitle(modifier = modifier, title = "Popular Curations")

                VerticalSpace(modifier = modifier)

                LazyRow {
                    item {
                        listOf(
                            "Burgers",
                            "South Indian",
                            "Pure Veg",
                            "North Indian",
                            "Burgers",
                            "South Indian",
                            "Pure Veg",
                            "North Indian",
                        ).forEach { curationName ->
                            ItemPopularCuration(
                                modifier = modifier,
                                curationName = curationName,
                                imageUrl = mainViewModel.getRandomTinyImage()
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
                        restaurantData.chunked(2).forEach { restaurants ->
                            ItemRestaurantRow(
                                modifier = modifier,
                                restaurants = restaurants,
                                imageUrls = listOf(
                                    mainViewModel.getRandomTinyImage(),
                                    mainViewModel.getRandomTinyImage()
                                )
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
                        couponData.forEach {
                            ItemCoupon(
                                modifier = modifier,
                                icon = it.icon,
                                tint = it.tint,
                                smallText = it.smallText,
                                largeText = it.largeText
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
                        restaurantData.forEach { restaurant ->
                            ItemRestaurantSmall(
                                modifier = modifier,
                                restaurant = restaurant,
                                imageUrl = mainViewModel.getRandomTinyImage()
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
                        restaurantData.chunked(2).forEach { restaurants ->
                            ItemRestaurantRow(
                                modifier = modifier,
                                restaurants = restaurants,
                                imageUrls = listOf(
                                    mainViewModel.getRandomTinyImage(),
                                    mainViewModel.getRandomTinyImage()
                                )
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
                restaurantData.chunked(1).forEach { restaurants ->
                    ItemRestaurantRow(
                        modifier = modifier,
                        restaurants = restaurants,
                        imageUrls = listOf(
                            mainViewModel.getRandomTinyImage(),
                        )
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