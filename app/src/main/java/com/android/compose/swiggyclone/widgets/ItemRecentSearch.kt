package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.greyDark

@Composable
fun ItemRecentSearch(modifier: Modifier, text: String) {
    Row(modifier = modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Search, "", tint = greyDark)
        HorizontalSpace(modifier = modifier)
        Text(
            text = text, style = Typography.body2.copy(
                color = greyDark, fontWeight = FontWeight.Light
            )
        )
    }
    Divider(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
    )
}