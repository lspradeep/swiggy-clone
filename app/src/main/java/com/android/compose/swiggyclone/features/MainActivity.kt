package com.android.compose.swiggyclone.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.SwiggyCloneApp
import com.android.compose.swiggyclone.ui.theme.SwiggyCloneTheme
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.greyLight
import com.android.compose.swiggyclone.widgets.EmptySpace
import com.android.compose.swiggyclone.widgets.ItemServiceType
import com.android.compose.swiggyclone.widgets.ItemBannerTypeOne
import com.android.compose.swiggyclone.widgets.ItemRestaurantSmall

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val modifier = Modifier
            App {
                Scaffold(
                    topBar = { SetUpToolbar(modifier) },
                    content = {
                        LazyColumn {
                            item {
                                Divider(color = greyLight)

                                EmptySpace(modifier = modifier)

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
                                                serviceName = serviceName
                                            )
                                        }
                                    }
                                }//end service type

                                EmptySpace(modifier = modifier)

                                ItemBannerTypeOne(modifier = modifier)

                                EmptySpace(modifier = modifier)

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
                                                modifier = modifier, restaurant = restaurant
                                            )
                                        }
                                    }
                                }

                            }
                        }
                    }
                )
            }
        }
    }
}


@Composable
private fun SetUpToolbar(modifier: Modifier) {
    TopAppBar(
        elevation = 0.dp
    ) {
        Text(
            text = "Home",
            modifier = modifier.padding(start = 8.dp, end = 8.dp),
            style = Typography.subtitle1.copy(fontWeight = FontWeight.Bold)
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_down_arrow),
            contentDescription = ""
        )
        Spacer(
            modifier = modifier
                .weight(1f)
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_discount),
            contentDescription = ""
        )
        Text(
            text = "Offers",
            modifier = modifier.padding(start = 8.dp, end = 8.dp),
            style = Typography.body2.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    SwiggyCloneTheme {
        content()
    }
}