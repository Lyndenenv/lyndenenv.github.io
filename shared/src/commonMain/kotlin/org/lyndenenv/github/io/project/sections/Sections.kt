package org.lyndenenv.github.io.project.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.unit.sp

data class Project(
    val title: String,
    val description: String,
    val tech: List<String>,
    val repoUrl: String,
    val demoUrl: String? = null,
    val status: String = "Open Source",
    val featured: Boolean = false,
)

private val sampleProjects = listOf(
    Project(
        title = "aladin",
        description = "Open-source Kotlin Multiplatform alternative to BlackRock Aladdin. " +
            "Full-stack financial platform: portfolio dashboard with AUM and P&L, risk analytics " +
            "(VaR 95/99%, Sharpe ratio, Beta, sector exposure), trade blotter with order entry, " +
            "and 30-day performance charts vs benchmark. Ktor 3 REST API, PostgreSQL 16 via Exposed ORM, " +
            "Compose Multiplatform on both web (Wasm) and Android.",
        tech = listOf("Kotlin Multiplatform", "Ktor 3", "Compose Multiplatform", "PostgreSQL", "Wasm", "Android"),
        repoUrl = "https://github.com/lyndenenv/aladin",
        status = "Open Source",
        featured = true,
    ),
    Project(
        title = "recon",
        description = "Network reconnaissance web UI. Enter a host and get open ports, service " +
            "banners (HTTP, SSH, SIP), and subnet sweep results in seconds. SIP/VoIP-aware — sends " +
            "real OPTIONS messages to probe 5060/5061. Built to understand your own network surface " +
            "before someone else does. Self-hosted: run with Python + Flask.",
        tech = listOf("Python", "Flask", "Scapy", "Sockets"),
        repoUrl = "https://github.com/lyndenenv/recon",
        status = "DevOps Tool",
    ),
    Project(
        title = "mogala",
        description = "Production VoIP SaaS. Hosted telephony, call routing, and communication " +
            "services for businesses — built on Asterisk and SIP. Currently live.",
        tech = listOf("VoIP", "SIP", "Asterisk", "JavaScript"),
        repoUrl = "https://github.com/lyndenenv/mogala",
        status = "Live SaaS",
    ),
    Project(
        title = "This portfolio",
        description = "Kotlin Multiplatform + Compose compiled to WebAssembly, deployed via " +
            "GitHub Actions. Every section, button, and animation is real compiled Kotlin — " +
            "no JavaScript framework.",
        tech = listOf("Kotlin", "Compose Multiplatform", "Wasm", "GitHub Actions"),
        repoUrl = "https://github.com/lyndenenv/lyndenenv.github.io",
        status = "Live",
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
        Text(
            "TECHNICAL TEAM LEAD · NXATEL",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.5.sp,
        )
        Text(
            "Lynden Tempies",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
        )
        Text(
            "DevOps Engineer & Infrastructure Architect",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            "13+ years building production systems — CI/CD pipelines, AWS infrastructure, " +
                "VoIP backends, and payment platforms. Now writing cross-platform apps with " +
                "Kotlin Multiplatform and Compose.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
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
        "AWS", "Docker", "CI/CD", "Linux (Debian/Ubuntu)", "Kotlin", "Ktor",
        "PHP", "PostgreSQL", "MySQL", "Asterisk / VoIP", "Paystack",
        "Compose Multiplatform", "GitHub Actions", "Kotlin Multiplatform",
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
                "Currently Technical Team Lead at Nxatel — running CI/CD, AWS infrastructure, and billing/" +
                "payment backends for a live telecom platform serving real customers. " +
                "Open to DevOps, infrastructure architecture, and cloud platform roles — contract, freelance, or full-time.",
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
        ) {
            sampleProjects.forEach { project ->
                ProjectCard(
                    project = project,
                    modifier = if (project.featured) {
                        Modifier.fillMaxWidth()
                    } else {
                        Modifier.widthIn(min = 280.dp).weight(1f)
                    },
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    ElevatedCard(modifier = modifier) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // Status label above title
            Text(
                project.status.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                project.title,
                style = if (project.featured) MaterialTheme.typography.headlineSmall
                else MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            Text(
                project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                project.tech.forEach { tech ->
                    SuggestionChip(onClick = {}, label = { Text(tech, style = MaterialTheme.typography.labelMedium) })
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextButton(onClick = {}) { Text("View on GitHub →") }
                if (project.demoUrl != null) {
                    TextButton(onClick = {}) { Text("Live demo →") }
                }
            }
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
        Text(
            "NOT A SCREENSHOT",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.5.sp,
        )
        Text(
            "This isn't a static page",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
        )
        Text(
            "Every pixel on this site is Kotlin, compiled to WebAssembly. " +
                "This button isn't JavaScript — it's real compiled Compose UI code running in your browser right now.",
            style = MaterialTheme.typography.bodyLarge,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            FilledTonalButton(onClick = { count++ }) { Text("Click me") }
            Text(
                if (count == 0) "Go on." else "Clicked $count ${if (count == 1) "time" else "times"}.",
                style = MaterialTheme.typography.titleMedium,
            )
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
            "Johannesburg, South Africa",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            "lyndentempies@gmail.com",
            style = MaterialTheme.typography.bodyLarge,
        )
        Text(
            "Available for contract, freelance, and full-time roles in DevOps, infrastructure architecture, and cloud platform engineering.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = {}) { Text("GitHub") }
            OutlinedButton(onClick = {}) { Text("Email") }
            OutlinedButton(onClick = {}) { Text("Resume (PDF)") }
        }
    }
}
