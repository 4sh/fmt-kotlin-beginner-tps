plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:${libs.versions.kotlin.get()}")
    implementation("org.jetbrains.kotlin.plugin.power-assert:org.jetbrains.kotlin.plugin.power-assert.gradle.plugin:${libs.versions.kotlin.get()}")

    // It works. Trust !!
    // https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
