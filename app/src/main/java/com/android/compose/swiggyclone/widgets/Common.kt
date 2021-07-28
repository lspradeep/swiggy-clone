package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptySpace(modifier: Modifier) {
    Spacer(modifier = modifier.height(8.dp))
}