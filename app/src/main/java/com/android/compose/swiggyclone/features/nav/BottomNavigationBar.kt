package com.android.compose.swiggyclone.features.nav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.ui.theme.greyDark
import com.android.compose.swiggyclone.ui.theme.secondaryVariant
import com.android.compose.swiggyclone.ui.theme.white

@Composable
fun BottomNavigationBar(navController: NavController, mainViewModel: MainViewModel = viewModel()) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Search,
        BottomNavigationItem.Cart,
        BottomNavigationItem.Account,
    )
    BottomNavigation(
        backgroundColor = white,
        contentColor = secondaryVariant
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = item.customIcon,
                label = { Text(text = item.route.routeName) },
                selectedContentColor = secondaryVariant,
                unselectedContentColor = greyDark,
                alwaysShowLabel = true,
                selected = currentRoute == item.route.routeName,
                onClick = {
                    if (currentRoute == item.route.routeName){
                        return@BottomNavigationItem
                    }
                    mainViewModel.incrementCartCounter()
                    mainViewModel.selectedNavMenu(item.route)
                    navController.navigate(item.route.routeName) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
