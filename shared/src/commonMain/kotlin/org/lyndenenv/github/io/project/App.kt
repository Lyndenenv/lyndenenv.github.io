package org.lyndenenv.github.io.project

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
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

// Fixed tones indexed by section position, stable for derivedStateOf capture
private val sectionTones = listOf(
    SectionTone.Light,
    SectionTone.Dark,
    SectionTone.Light,
    SectionTone.Dark,
    SectionTone.Light,
)

@Composable
fun App() {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    fun scrollToSection(index: Int) {
        coroutineScope.launch { listState.animateScrollToItem(index) }
    }

    val sections = listOf(
        Section(SectionTone.Light) { HeroSection(onScrollToProjects = { scrollToSection(2) }) },
        Section(SectionTone.Dark) { AboutSection() },
        Section(SectionTone.Light) { ProjectsSection() },
        Section(SectionTone.Dark) { LiveDemoSection() },
        Section(SectionTone.Light) { ContactSection() },
    )

    val darkFraction by remember(listState) {
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
                    val tone = if (sectionTones.getOrNull(item.index) == SectionTone.Dark) 1f else 0f
                    weightedTone += tone * coverage
                    totalCoverage += coverage
                }
            }
            if (totalCoverage <= 0f) 0f else weightedTone / totalCoverage
        }
    }

    val backgroundColor by animateColorAsState(lerp(LightColors.background, DarkColors.background, darkFraction))

    Box(modifier = Modifier.fillMaxSize().background(backgroundColor)) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 64.dp),
        ) {
            itemsIndexed(sections) { _, section ->
                PortfolioTheme(tone = section.tone) {
                    section.content()
                }
            }
        }

        // Sticky nav bar rendered on top of the scroll content
        PortfolioTheme(SectionTone.Light) {
            NavBar(
                onNavigate = { index -> scrollToSection(index) },
            )
        }
    }
}

@Composable
private fun NavBar(
    onNavigate: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        tonalElevation = 3.dp,
        shadowElevation = 4.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(64.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                "Lynden Tempies",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Row(horizontalArrangement = Arrangement.spacedBy(0.dp)) {
                listOf("Hero" to 0, "About" to 1, "Projects" to 2, "Contact" to 4).forEach { (label, index) ->
                    TextButton(onClick = { onNavigate(index) }) {
                        Text(label, style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
        }
    }
}
