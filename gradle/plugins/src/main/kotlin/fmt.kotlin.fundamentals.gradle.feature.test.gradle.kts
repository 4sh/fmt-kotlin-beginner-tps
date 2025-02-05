plugins {
    kotlin("jvm")
    kotlin("plugin.power-assert")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.engine)
    testImplementation(libs.junit.params)
    testImplementation(libs.strikt)
}

tasks.test {
    useJUnitPlatform()
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
powerAssert {
    functions.set(
        listOf(
            "kotlin.assert",
            "kotlin.require",
            "kotlin.requireNotNull",
            "kotlin.check",
            "kotlin.checkNotNull",
            "kotlin.test.assertTrue",
            "kotlin.test.assertFalse",
            "kotlin.test.assertEquals",
            "kotlin.test.assertNull",
        )
    )
}
