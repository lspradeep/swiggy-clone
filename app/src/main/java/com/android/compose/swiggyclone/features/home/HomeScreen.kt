package com.android.compose.swiggyclone.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.features.ResourceStatus
import com.android.compose.swiggyclone.ui.theme.secondaryColor
import com.android.compose.swiggyclone.widgets.*

@Composable
fun HomeScreen(modifier: Modifier, mainViewModel: MainViewModel = viewModel()) {
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

                SectionTitle(
                    modifier = modifier,
                    leadIcon = Icons.Default.Favorite,
                    title = "Restaurants You love"
                )

                VerticalSpace(modifier = modifier)

                //restaurants
                LazyRow {
                    item {
                        listOf(
                            Triple("Muniyandi Vilas", "20 mins", 30),
                            Triple("Lamia Multicuisine", "24 mins", 20),
                            Triple("Meat and Eat", "35 mins", 10),
                            Triple("KFC", "25 mins", 30),
                            Triple("Muniyandi Vilas", "20 mins", 30),
                            Triple("Lamia Multicuisine", "24 mins", 20),
                            Triple("Meat and Eat", "35 mins", 10),
                            Triple("KFC", "25 mins", 30),
                        ).forEach { restaurant ->
                            ItemRestaurantSmall(
                                modifier = modifier,
                                restaurant = restaurant,
                                imageUrl = mainViewModel.getRandomTinyImage()
                            )
                        }
                    }
                }

                VerticalSpace(modifier = modifier)

                SectionTitle(modifier = modifier, title = "Popular Curations")

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