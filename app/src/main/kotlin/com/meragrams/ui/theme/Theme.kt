package com.meragrams.ui.theme

import androidx.compose.foundation.isSystemInDarkMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6D4CFF),
    secondary = Color(0xFFFF6B9D),
    tertiary = Color(0xFF00D9FF),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6D4CFF),
    secondary = Color(0xFFFF6B9D),
    tertiary = Color(0xFF00D9FF),
    background = Color(0xFFFAFAFA),
    surface = Color(0xFFFFFFFF),
)

@Composable
fun MeraGramTheme(
    darkTheme: Boolean = isSystemInDarkMode(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
