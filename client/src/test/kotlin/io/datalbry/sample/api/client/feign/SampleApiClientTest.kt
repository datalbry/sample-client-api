package io.datalbry.sample.api.client.feign

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.net.URI

class SampleApiClientTest {

    private val config = SampleApiClientConfig(
        URI(System.getenv()["sample-api-uri"]!!),
    )
    private val client = SampleApiClientFactory().create(config)

    @Test
    fun verifyModel_worksJustFine() {
        val personIds = client.getPersonIds().asSequence().toList()
        val persons = personIds.map { client.getPerson(it) }
        assertTrue(persons.isNotEmpty())
        val computerIds = personIds.flatMap { client.getComputerIds(it).asSequence().toList() }
        assertTrue(computerIds.isNotEmpty())
        val computers = computerIds.map { client.getComputer(it) }
        assertTrue(computers.isNotEmpty())
        val projects = personIds.flatMap { client.getProjects(it).asSequence().toList() }
        assertTrue(projects.isNotEmpty())

        val officePets = client.getOfficePets().asSequence().toList()
        assertTrue(officePets.isNotEmpty())
        val petToyIds = officePets.flatMap { client.getPetToysForOfficePet(it.id).asSequence().toList() }
        assertTrue(petToyIds.isNotEmpty())
        val petToys = petToyIds.map { client.getPetToy(it) }
        assertTrue(petToys.isNotEmpty())
    }
}