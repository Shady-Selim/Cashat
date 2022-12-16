package com.cassbana.cashat.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorPalette = darkColorScheme(
    primary = RoyalBlue1,
    secondary = Neutral6
)

private val LightColorPalette = lightColorScheme(
    primary = RoyalBlue3,
    secondary = Neutral8
)


@Composable
fun CassbanaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(
        LocalReplacementTypography provides tajawalTypography
    ) {
        MaterialTheme(
            colorScheme = colors,
            shapes = Shapes,
            content = content
        )
    }
}

object CassbanaTheme {
    val typography: TajawalTypography
        @Composable
        get() = LocalReplacementTypography.current
}