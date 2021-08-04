package com.android.compose.swiggyclone.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.android.compose.swiggyclone.R
import com.android.compose.swiggyclone.features.nav.BottomNavigationBar
import com.android.compose.swiggyclone.features.nav.Routes
import com.android.compose.swiggyclone.features.nav.Navigation
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


@Preview(showBackground = false)
@Preview
@Composable
fun App() {
    SwiggyCloneTheme {
        val modifier = Modifier
        val navController = rememberNavController()
        Scaffold(
            topBar = { SetUpToolbar(modifier) }, bottomBar = {
                BottomNavigationBar(navController)
            },
            content = {
                Navigation(navController, modifier = modifier)
            }
        )
    }
}

@Composable
private fun SetUpToolbar(modifier: Modifier, mainViewModel: MainViewModel = viewModel()) {
    val selectedNavMenuItem = mainViewModel.selectedMenuItem.observeAsState()
    if (selectedNavMenuItem.value?.routeName == Routes.HOME.routeName) TopAppBar(
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

