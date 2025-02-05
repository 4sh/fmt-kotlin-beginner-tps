plugins {
    kotlin("jvm")
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
