package com.android.compose.swiggyclone.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.features.cart.CartScreen
import com.android.compose.swiggyclone.features.search.SearchScreen
import com.android.compose.swiggyclone.features.home.HomeScreen
import com.android.compose.swiggyclone.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
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
fun App(mainViewModel: MainViewModel = viewModel()) {
    SwiggyCloneTheme {
        val modifier = Modifier
        val selectedMenu = remember { mutableStateOf(0) }
        Scaffold(
            topBar = { if (selectedMenu.value == 0) SetUpToolbar(modifier) }, bottomBar = {
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
                when (selectedMenu.value) {
                    0 -> {
                        HomeScreen(modifier = modifier)
                    }
                    1 -> {
                        SearchScreen(modifier = modifier)
                    }
                    2 -> {
                        CartScreen(modifier = modifier)
                    }
                    else -> {
                        Box(
                            modifier = modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Under construction", style = Typography.h6)
                        }
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
    mainViewModel: MainViewModel = viewModel(),
    callback: (Int) -> Unit,
) {
    val color = if (id == selected) secondaryVariant else greyDark
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .align(alignment = Alignment.Center)
                .clickable {
                    callback(id)
                }
                .size(70.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = color
            )
            Text(text = title.uppercase(), style = Typography.caption.copy(color = color))
        }

        if (selected != id && id == 2) {
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = modifier
                    .size(50.dp)
                    .background(color = Color.Transparent)
            ) {
                Text(
                    text = "3",
                    style = Typography.caption.copy(color = white),
                    modifier = modifier
                        .align(alignment = Alignment.Center)
                        .clip(CircleShape)
                        .background(
                            color = secondaryColor,
                            shape = CircleShape.copy(all = CornerSize(percent = 25))
                        )
                        .size(18.dp)
                        .padding(2.dp)
                        .wrapContentSize(),
                )
            }
        }
    }
}
