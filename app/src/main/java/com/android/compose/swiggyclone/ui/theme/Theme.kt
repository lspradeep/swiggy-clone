package com.android.compose.swiggyclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    primaryVariant = primaryVariant,
    secondary = secondaryColor,
    secondaryVariant = secondaryVariant,
    onPrimary = black,
    onSecondary = black,
    background = white
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = primaryVariant,
    secondary = secondaryColor,
    secondaryVariant = secondaryVariant,
    onPrimary = black,
    onSecondary = black,
    background = white

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SwiggyCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}