plugins {
    id("datalbry.kotlin")
    id("datalbry.publication")
}

tasks.withType<Test> {
    environment["sample-api-uri"] = properties["datalbry.sample.api.uri"]
}

dependencies {
    api(project(":client-api"))
    implementation(libs.bundles.feign)
    implementation(libs.bundles.jackson)
    testImplementation(libs.bundles.junit)
}
