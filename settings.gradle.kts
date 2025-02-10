pluginManagement {
    includeBuild("gradle/plugins")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "fmt-kotlin-beginner-tps"

include("tp0")
include("tp1")
include("tp2")
include("tp3")
include("tp3-other-module")
include("tp4")
