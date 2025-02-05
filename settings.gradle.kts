pluginManagement {
    includeBuild("gradle/plugins")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("fmt.kotlin.fundamentals.gradle.project-structure")
    id("fmt.kotlin.fundamentals.gradle.scans")
}

rootProject.name = "fmt-kotlin-beginner-tps"
