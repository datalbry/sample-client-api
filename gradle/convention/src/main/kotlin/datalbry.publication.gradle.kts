plugins {
    signing
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            publication()
            pom()
        }
    }
}

configure<SigningExtension> {
    useGpgCmd()
    sign(publishing.publications["maven"])
}

fun MavenPublication.pom() {
    pom {
        name.set("Sample API ${project.name}")
        description.set("Client implementation for the Sample API")
        url.set("https://github.com/datalbry/sample-api-client")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("datalbry")
                name.set("DataLbry")
                email.set("devops@datalbry.io")
            }
        }
        scm {
            connection.set("https://github.com/datalbry/sample-api-client.git")
            developerConnection.set("scm:git:ssh:git@github.com:datalbry/sample-api-client.git")
            url.set("https://github.com/datalbry/sample-api-client")
        }
    }
}

fun MavenPublication.publication() {
    val projectGroup = project.group as String
    val projectVersion = project.version as String
    artifactId = "${projectGroup.substringAfterLast(".")}-${project.name}"
    version = projectVersion
    from(components["java"])
}
