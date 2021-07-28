package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.compose.swiggyclone.ui.theme.Typography

@Composable
fun EmptySpace(modifier: Modifier) {
    Spacer(modifier = modifier.height(16.dp))
}

@Composable
fun SectionTitle(title: String) {
    Text(text = title, style = Typography.subtitle1.copy(fontWeight = FontWeight.ExtraBold))
}