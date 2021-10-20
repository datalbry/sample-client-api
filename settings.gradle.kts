enableFeaturePreview("VERSION_CATALOGS")
rootProject.name = "sample-api"

pluginManagement {
        repositories {
                gradlePluginPortal()
                mavenCentral()
                google()
        }
}

includeBuild("gradle/convention")

include(
        "client",
        "client-api"
)