package io.datalbry.sample.api.client

import io.datalbry.sample.api.client.model.*

interface PersonEndpointClient {

    fun getPersonIds(): Iterator<PersonId>
    fun getPerson(personId: PersonId): Person
    fun getComputerIds(personId: PersonId): Iterator<ComputerId>
    fun getComputer(computerId: ComputerId): Computer
    fun getProjects(personId: PersonId): Iterator<Project>
}