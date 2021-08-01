package com.android.compose.swiggyclone.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.android.compose.swiggyclone.ui.theme.Typography
import com.android.compose.swiggyclone.ui.theme.secondaryColor

@Composable
fun ItemSectionTitle(modifier: Modifier, leadIcon: ImageVector? = null, title: String) {
    if (leadIcon == null) {
        Text(text = title, style = Typography.subtitle1.copy(fontWeight = FontWeight.ExtraBold))
    } else {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(leadIcon, "", tint = secondaryColor)
            HorizontalSpace(modifier = modifier)
            Text(text = title, style = Typography.subtitle1.copy(fontWeight = FontWeight.ExtraBold))
        }
    }
}