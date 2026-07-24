package org.lyndenenv.github.io.project.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Project(
    val title: String,
    val description: String,
    val tech: List<String>,
    val repoUrl: String,
    val demoUrl: String? = null,
)

private val sampleProjects = listOf(
    Project(
        title = "recon",
        description = "Network reconnaissance toolkit — passive host discovery, port scanning, and service fingerprinting via a Python/Flask web UI.",
        tech = listOf("Python", "Flask", "Scapy"),
        repoUrl = "https://github.com/lyndenenv/recon",
    ),
    Project(
        title = "This portfolio",
        description = "Kotlin Multiplatform + Compose, compiled to WebAssembly and deployed via GitHub Actions. Real Kotlin running in your browser.",
        tech = listOf("Kotlin", "Compose Multiplatform", "Wasm", "GitHub Actions"),
        repoUrl = "https://github.com/lyndenenv/lyndenenv.github.io",
    ),
)

@Composable
fun HeroSection(
    modifier: Modifier = Modifier,
    onScrollToProjects: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp, vertical = 96.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("Lynden Tempies", style = MaterialTheme.typography.displayLarge, fontWeight = FontWeight.Bold)
        Text("DevOps Engineer & Infrastructure Architect", style = MaterialTheme.typography.headlineSmall)
        Text(
            "13+ years engineering production systems — CI/CD pipelines, cloud infrastructure, " +
                "VoIP backends and payment platforms. Now building cross-platform apps with Kotlin " +
                "Multiplatform and Compose.",
            style = MaterialTheme.typography.bodyLarge,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { onScrollToProjects?.invoke() }) { Text("View projects") }
            OutlinedButton(onClick = {}) { Text("Download resume") }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    val skills = listOf(
        "AWS", "Docker", "CI/CD", "Linux (Debian/Ubuntu)", "Kotlin", "PHP", "PostgreSQL", "MySQL",
        "Asterisk / VoIP", "Paystack", "Compose Multiplatform",
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Text("About", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
        Text(
            "Senior DevOps Engineer and Infrastructure Architect with 13+ years designing, deploying, " +
                "and maintaining production-grade systems across telecom, cloud, and backend engineering. " +
                "Currently Technical Team Lead at Nxatel, running CI/CD, AWS infrastructure, and billing/" +
                "payment backends for a telecom platform. Open to DevOps, infrastructure architecture, and " +
                "cloud platform roles — contract, freelance, or full-time.",
            style = MaterialTheme.typography.bodyLarge,
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            skills.forEach { skill -> AssistChip(onClick = {}, label = { Text(skill) }) }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp, vertical = 80.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Text("Projects", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 2,
        ) {
            sampleProjects.forEach { project ->
                ProjectCard(project, modifier = Modifier.weight(1f))
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    ElevatedCard(modifier = modifier) {
        Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(project.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
            Text(project.description, style = MaterialTheme.typography.bodyMedium)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                project.tech.forEach { tech -> SuggestionChip(onClick = {}, label = { Text(tech) }) }
            }
            TextButton(onClick = {}) { Text("View on GitHub →") }
        }
    }
}

@Composable
fun LiveDemoSection(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp, vertical = 96.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("This isn't a screenshot", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
        Text(
            "This whole page is Kotlin, compiled to WebAssembly. This button is running real, compiled Compose UI code in your browser right now.",
            style = MaterialTheme.typography.bodyLarge,
        )
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            FilledTonalButton(onClick = { count++ }) { Text("Click me") }
            Text("Clicked $count times", style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp, vertical = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text("Let's talk", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.SemiBold)
        Text(
            "Johannesburg, South Africa · lyndentempies@gmail.com · Available for contract, freelance & full-time roles",
            style = MaterialTheme.typography.bodyLarge,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedButton(onClick = {}) { Text("GitHub") }
            OutlinedButton(onClick = {}) { Text("Email") }
            OutlinedButton(onClick = {}) { Text("Resume (PDF)") }
        }
    }
}
