package com.android.compose.swiggyclone.features.nav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.secondaryColor
import com.android.compose.swiggyclone.ui.theme.white

enum class NavRoutes(val routeName: String) {
    HOME("Home"),
    SEARCH("Search"),
    CART("Cart"),
    ACCOUNT("Account")
}

sealed class NavigationItem(
    var route: NavRoutes,
    var customIcon: @Composable () -> Unit,
) {
    object Home :
        NavigationItem(NavRoutes.HOME, { Icon(Icons.Default.Home, "") })

    object Search :
        NavigationItem(NavRoutes.SEARCH, { Icon(Icons.Default.Search, "") })

    object Cart :
        NavigationItem(NavRoutes.CART, { CartIcon() })

    object Account :
        NavigationItem(
            NavRoutes.ACCOUNT,
            { Icon(Icons.Default.Person, "") },
        )
}

@Composable
fun CartIcon(mainViewModel: MainViewModel = viewModel()) {
    val modifier = Modifier
    val selectedNavMenuItem = mainViewModel.selectedNavMenuItem.observeAsState()
    ConstraintLayout {
        val (iconId, counterId) = createRefs()
        Icon(Icons.Default.ShoppingCart, "", modifier = modifier.constrainAs(iconId) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        if (selectedNavMenuItem.value?.routeName != NavRoutes.CART.routeName) Text(
            text = "3",
            style = Typography.caption.copy(color = white),
            modifier = modifier
                .constrainAs(counterId) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.top)
                    start.linkTo(parent.end)
                    end.linkTo(parent.end)
                }
                .clip(CircleShape)
                .background(
                    color = secondaryColor,
                    shape = CircleShape.copy(all = CornerSize(percent = 25))
                )
                .size(16.dp)
                .padding(1.dp)
                .wrapContentSize(),
        )
    }
}