package com.android.compose.swiggyclone.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.ui.theme.*
import com.android.compose.swiggyclone.widgets.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}


@Composable
private fun SetUpToolbar(modifier: Modifier) {
    TopAppBar(
        elevation = 4.dp,
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

@Preview(showBackground = false)
@Preview
@Composable
fun App() {
    SwiggyCloneTheme {
        val modifier = Modifier
        val selectedMenu = remember { mutableStateOf(0) }
        Scaffold(
            topBar = { SetUpToolbar(modifier) }, bottomBar = {
                BottomNavigation(contentColor = primaryColor) {
                    BottomNavBarItem(
                        modifier = modifier.weight(1f),
                        0,
                        selectedMenu.value,
                        Icons.Default.Home,
                        "Home"
                    ) {
                        selectedMenu.value = 0
                    }
                    BottomNavBarItem(
                        modifier = modifier.weight(1f),
                        1,
                        selectedMenu.value,
                        Icons.Default.Search,
                        "Search"
                    ) {
                        selectedMenu.value = 1
                    }
                    BottomNavBarItem(
                        modifier = modifier.weight(1f),
                        2,
                        selectedMenu.value,
                        Icons.Default.ShoppingCart,
                        "Cart"
                    ) {
                        selectedMenu.value = 2
                    }
                    BottomNavBarItem(
                        modifier = modifier.weight(1f),
                        3,
                        selectedMenu.value,
                        Icons.Default.Person,
                        "Account"
                    ) {
                        selectedMenu.value = 3
                    }
                }
            },
            content = {
                LazyColumn(
                    contentPadding = PaddingValues(start=8.dp,end = 8.dp,top = 8.dp,bottom = 100.dp),
                ) {
                    item {
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
                                        serviceName = serviceName,
                                        description = "Enjoy Your favourite treats"
                                    )
                                }
                            }
                        }//end service type

                        EmptySpace(modifier = modifier)

                        ItemBannerTypeOne(modifier = modifier)

                        EmptySpace(modifier = modifier)

                        SectionTitle(title = "Restaurants You love")

                        EmptySpace(modifier = modifier)

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
                                        modifier = modifier, restaurant = restaurant
                                    )
                                }
                            }
                        }

                        EmptySpace(modifier = modifier)

                        SectionTitle(title = "Popular Curations")

                        EmptySpace(modifier = modifier)

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
                                        curationName = curationName
                                    )
                                }
                            }
                        }

                        EmptySpace(modifier = modifier)

                    }
                }
            }
        )
    }
}

@Composable
fun BottomNavBarItem(
    modifier: Modifier,
    id: Int,
    selected: Int,
    icon: ImageVector,
    title: String,
    callback: (Int) -> Unit
) {
    val color = if (id == selected) secondaryVariant else greyDark
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(4.dp)
            .clickable {
                callback(id)
            }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = color
        )
        Text(text = title, style = Typography.caption.copy(color = color))
    }
}
