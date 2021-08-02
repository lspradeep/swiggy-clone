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
import com.android.compose.swiggyclone.features.search.SearchScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.HOME.routeName) {
        val modifier = Modifier
        composable(NavRoutes.HOME.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            HomeScreen(modifier = modifier, mainViewModel)
        }
        composable(NavRoutes.SEARCH.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(NavRoutes.HOME.routeName)
            )
            SearchScreen(modifier = modifier, mainViewModel)
        }
        composable(NavRoutes.CART.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(NavRoutes.HOME.routeName)
            )
            CartScreen(modifier = modifier)
        }
        composable(NavRoutes.ACCOUNT.routeName) {
            val mainViewModel = hiltViewModel<MainViewModel>(
                navController.getBackStackEntry(NavRoutes.HOME.routeName)
            )
            AccountScreen(modifier = modifier)
        }
    }
}