package org.lyndenenv.github.io.project

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.lyndenenv.github.io.project.sections.AboutSection
import org.lyndenenv.github.io.project.sections.ContactSection
import org.lyndenenv.github.io.project.sections.HeroSection
import org.lyndenenv.github.io.project.sections.LiveDemoSection
import org.lyndenenv.github.io.project.sections.ProjectsSection
import org.lyndenenv.github.io.project.theme.PortfolioTheme
import org.lyndenenv.github.io.project.theme.SectionTone

// Each section carries its own tone. Scrolling past a section boundary
// flips the whole color scheme -- background, text, buttons, chips --
// giving the alternating light/dark effect as you scroll down the page.
private data class Section(val tone: SectionTone, val content: @Composable () -> Unit)

@Composable
fun App() {
    val sections = listOf(
        Section(SectionTone.Light) { HeroSection() },
        Section(SectionTone.Dark) { AboutSection() },
        Section(SectionTone.Light) { ProjectsSection() },
        Section(SectionTone.Dark) { LiveDemoSection() },
        Section(SectionTone.Light) { ContactSection() },
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(sections) { _, section ->
            PortfolioTheme(tone = section.tone) {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                ) {
                    section.content()
                }
            }
        }
    }
}
