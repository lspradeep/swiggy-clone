package com.android.compose.swiggyclone.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.features.MainViewModel
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.grey
import com.android.compose.swiggyclone.ui.theme.greyLight
import com.android.compose.swiggyclone.ui.theme.secondaryColor
import com.android.compose.swiggyclone.widgets.ItemPopularCuration
import com.android.compose.swiggyclone.widgets.ItemRecentSearch
import com.android.compose.swiggyclone.widgets.ItemSectionTitle
import com.android.compose.swiggyclone.widgets.VerticalSpace

@Composable
fun SearchScreen(modifier: Modifier, mainViewModel: MainViewModel) {
    val recentSearches = mainViewModel.recentSearches.observeAsState()
    val curations by mainViewModel.curations.observeAsState()
    val showMore = remember { mutableStateOf(false) }
    if (showMore.value) mainViewModel.showMoreRecentSearches() else mainViewModel.showLessRecentSearches()

    LazyColumn(
        contentPadding = PaddingValues(
            top = 8.dp,
            bottom = 100.dp,
            start = 8.dp,
            end = 8.dp
        )
    ) {

        item {
            VerticalSpace(modifier = modifier)
        }

        item {
            val searchInput = remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = greyLight, shape = RoundedCornerShape(8.dp))
                    .border(width = 1.dp, color = grey, shape = RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp)),
                value = searchInput.value,
                onValueChange = {
                    searchInput.value = it
                },
                placeholder = { Text(text = "Search for restaurants or food") },
                maxLines = 1,
            )
        }

        item {
            VerticalSpace(modifier = modifier)
        }

        item {
            Row {
                Text(
                    text = "Recent Searches",
                    style = Typography.subtitle1.copy(fontWeight = FontWeight.ExtraBold),
                )
                Spacer(modifier = modifier.weight(1f))
                Text(
                    modifier = modifier.clickable {
                        showMore.value = !showMore.value
                        if (showMore.value) mainViewModel.showMoreRecentSearches() else mainViewModel.showLessRecentSearches()
                    },
                    text = if (showMore.value) "Show Less".uppercase() else "Show More".uppercase(),
                    style = Typography.body2.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = secondaryColor
                    ),
                )
            }

            VerticalSpace(modifier = modifier)

            Column {
                recentSearches.value?.forEach {
                    ItemRecentSearch(modifier = modifier, text = it)
                }
            }
        }

        item {
            VerticalSpace(modifier = modifier)
        }

        item {
            ItemSectionTitle(modifier = modifier, title = "Popular Cuisines")

            VerticalSpace(modifier = modifier)

            LazyRow {
                item {
                    curations?.forEach { curation ->
                        ItemPopularCuration(
                            modifier = modifier,
                            curationName = curation.name,
                            imageUrl = curation.image
                        )
                    }
                }
            }
        }
    }
}