package org.lyndenenv.github.io.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform