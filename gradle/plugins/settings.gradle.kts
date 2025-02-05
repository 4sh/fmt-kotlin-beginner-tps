// https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}
