package org.lyndenenv.github.io.project.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Material 3 tonal palette hand-derived from a pink seed color (~#E91E63).
// For a pixel-perfect algorithmic palette, plug the same seed into
// https://m3.material.io/theme-builder and paste the exported values here.

val md_theme_light_primary = Color(0xFFB0004D)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFFFD9E2)
val md_theme_light_onPrimaryContainer = Color(0xFF3F0018)
val md_theme_light_secondary = Color(0xFF74565C)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFD9E2)
val md_theme_light_onSecondaryContainer = Color(0xFF2B151A)
val md_theme_light_tertiary = Color(0xFF7C5635)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFDCBE)
val md_theme_light_onTertiaryContainer = Color(0xFF2E1500)
val md_theme_light_background = Color(0xFFFFF8F7)
val md_theme_light_onBackground = Color(0xFF22191A)
val md_theme_light_surface = Color(0xFFFFF8F7)
val md_theme_light_onSurface = Color(0xFF22191A)
val md_theme_light_surfaceVariant = Color(0xFFF3DDE0)
val md_theme_light_onSurfaceVariant = Color(0xFF524345)
val md_theme_light_outline = Color(0xFF847375)

val md_theme_dark_primary = Color(0xFFFFB1C8)
val md_theme_dark_onPrimary = Color(0xFF650033)
val md_theme_dark_primaryContainer = Color(0xFF8E0049)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFD9E2)
val md_theme_dark_secondary = Color(0xFFE2BDC2)
val md_theme_dark_onSecondary = Color(0xFF422931)
val md_theme_dark_secondaryContainer = Color(0xFF5A3F47)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFD9E2)
val md_theme_dark_tertiary = Color(0xFFEFBD94)
val md_theme_dark_onTertiary = Color(0xFF48290B)
val md_theme_dark_tertiaryContainer = Color(0xFF623F20)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFDCBE)
val md_theme_dark_background = Color(0xFF191113)
val md_theme_dark_onBackground = Color(0xFFEEDFE0)
val md_theme_dark_surface = Color(0xFF191113)
val md_theme_dark_onSurface = Color(0xFFEEDFE0)
val md_theme_dark_surfaceVariant = Color(0xFF524345)
val md_theme_dark_onSurfaceVariant = Color(0xFFD6C2C4)
val md_theme_dark_outline = Color(0xFF9F8C8E)

val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
)

val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
)
