package com.android.compose.swiggyclone.features.restaurantdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.ui.theme.Typography

@Composable
fun RestaurantDetailScreen(modifier: Modifier, mainViewModel: MainViewModel) {
    val cartIncrement = mainViewModel.incrementCartCount.observeAsState()
    Scaffold(
        content = {
            Box(modifier = modifier
                .fillMaxSize()
                .clickable {
                    mainViewModel.incrementCartCounter()
                }, contentAlignment = Alignment.Center
            ) {
                Text(text = "${cartIncrement.value}", style = Typography.h6, modifier = modifier)
            }
        }
    )
}