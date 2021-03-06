package com.android.compose.swiggyclone.features.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.features.account.AccountScreen
import com.android.compose.swiggyclone.features.cart.CartScreen
import com.android.compose.swiggyclone.features.home.HomeScreen
import com.android.compose.swiggyclone.features.restaurantdetail.RestaurantDetailScreen
import com.android.compose.swiggyclone.features.search.SearchScreen

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = Routes.HOME.routeName) {
        composable(Routes.HOME.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(Routes.HOME.routeName)
            )
            HomeScreen(modifier = modifier, navController = navController, mainViewModel)
        }
        composable(Routes.SEARCH.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(Routes.HOME.routeName)
            )
            SearchScreen(modifier = modifier, mainViewModel)
        }
        composable(Routes.CART.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(Routes.HOME.routeName)
            )
            CartScreen(modifier = modifier)
        }
        composable(Routes.ACCOUNT.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(Routes.HOME.routeName)
            )
            AccountScreen(modifier = modifier)
        }
        composable(Routes.RESTAURANT_DETAIL.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(Routes.HOME.routeName)
            )
            RestaurantDetailScreen(modifier = modifier, mainViewModel)
        }
    }
}