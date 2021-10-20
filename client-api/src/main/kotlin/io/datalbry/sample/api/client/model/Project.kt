package io.datalbry.sample.api.client.model

data class Project(
    val id: String,
    val personId: String,
    val projectName: String,
    val projectInformation: ProjectInformation
)