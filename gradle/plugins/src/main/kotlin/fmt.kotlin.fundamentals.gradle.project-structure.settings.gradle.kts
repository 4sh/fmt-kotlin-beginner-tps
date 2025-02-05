rootDir
    .listFiles()
    .filter { it.resolve("build.gradle.kts").exists() }
    .forEach { include(it.name) }
