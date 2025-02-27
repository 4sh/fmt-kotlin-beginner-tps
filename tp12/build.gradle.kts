plugins {
    id("fmt.kotlin.fundamentals.gradle.component.tp")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("io.mockk:mockk:1.13.16")
    testImplementation("io.strikt:strikt-gradle:0.31.0")
}