plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(25)

    compilerOptions {
        freeCompilerArgs.add("-Xreturn-value-checker=full")
    }
}
