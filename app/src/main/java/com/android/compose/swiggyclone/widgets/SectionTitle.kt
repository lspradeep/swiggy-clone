package com.android.compose.swiggyclone.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.android.compose.swiggyclone.ui.theme.Typography

@Composable
fun SectionTitle(title: String) {
    Text(text = title, style = Typography.subtitle1.copy(fontWeight = FontWeight.ExtraBold))
}