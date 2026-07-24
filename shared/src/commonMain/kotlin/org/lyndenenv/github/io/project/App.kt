package org.lyndenenv.github.io.project

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.lerp
import org.lyndenenv.github.io.project.sections.AboutSection
import org.lyndenenv.github.io.project.sections.ContactSection
import org.lyndenenv.github.io.project.sections.HeroSection
import org.lyndenenv.github.io.project.sections.LiveDemoSection
import org.lyndenenv.github.io.project.sections.ProjectsSection
import org.lyndenenv.github.io.project.theme.DarkColors
import org.lyndenenv.github.io.project.theme.LightColors
import org.lyndenenv.github.io.project.theme.PortfolioTheme
import org.lyndenenv.github.io.project.theme.SectionTone

private data class Section(val tone: SectionTone, val content: @Composable () -> Unit)

@Composable
fun App() {
    val sections = remember {
        listOf(
            Section(SectionTone.Light) { HeroSection() },
            Section(SectionTone.Dark) { AboutSection() },
            Section(SectionTone.Light) { ProjectsSection() },
            Section(SectionTone.Dark) { LiveDemoSection() },
            Section(SectionTone.Light) { ContactSection() },
        )
    }

    val listState = rememberLazyListState()

    val darkFraction by remember {
        derivedStateOf {
            val info = listState.layoutInfo
            val viewportHeight = (info.viewportEndOffset - info.viewportStartOffset).toFloat()
            if (info.visibleItemsInfo.isEmpty() || viewportHeight <= 0f) return@derivedStateOf 0f

            var weightedTone = 0f
            var totalCoverage = 0f
            info.visibleItemsInfo.forEach { item ->
                val top = item.offset.coerceAtLeast(0)
                val bottom = (item.offset + item.size).coerceAtMost(viewportHeight.toInt())
                val coverage = (bottom - top).coerceAtLeast(0).toFloat()
                if (coverage > 0f) {
                    val tone = if (sections.getOrNull(item.index)?.tone == SectionTone.Dark) 1f else 0f
                    weightedTone += tone * coverage
                    totalCoverage += coverage
                }
            }
            if (totalCoverage <= 0f) 0f else weightedTone / totalCoverage
        }
    }

    val backgroundColor by animateColorAsState(lerp(LightColors.background, DarkColors.background, darkFraction))

    Box(modifier = Modifier.fillMaxSize().background(backgroundColor)) {
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            itemsIndexed(sections) { _, section ->
                PortfolioTheme(tone = section.tone) {
                    section.content()
                }
            }
        }
    }
}