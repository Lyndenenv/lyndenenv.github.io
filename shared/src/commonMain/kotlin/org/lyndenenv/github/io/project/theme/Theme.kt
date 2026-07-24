package org.lyndenenv.github.io.project.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

enum class SectionTone { Light, Dark }

@Composable
fun PortfolioTheme(tone: SectionTone, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (tone == SectionTone.Light) LightColors else DarkColors,
        typography = portfolioTypography(),
        content = content,
    )
}