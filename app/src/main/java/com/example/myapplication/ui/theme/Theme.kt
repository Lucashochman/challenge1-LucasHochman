package com.example.myapplication.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = BrandBlue,
    onPrimary = Color.White,
    primaryContainer = BrandBlueLight,
    onPrimaryContainer = BrandBlueDark,

    secondary = BrandBlue,
    onSecondary = Color.White,

    surface = Color.White,
    onSurface = TextPrimary,
    background = SurfaceSoft,
    onBackground = TextPrimary,

    outline = OutlineBlue
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,   // usa el de Type.kt
        content = content
    )
}
