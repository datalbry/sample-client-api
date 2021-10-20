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
        val objectAIds = client.getPersonIds().asSequence().toList()
        val objectAs = objectAIds.map { client.getPerson(it) }
        assertTrue(objectAIds.isNotEmpty())
        val objectBIds = objectAIds.flatMap { client.getComputerIds(it).asSequence().toList() }
        assertTrue(objectBIds.isNotEmpty())
        val objectBs = objectBIds.map { client.getComputer(it) }
        val objectCs = objectAIds.flatMap { client.getProjects(it).asSequence().toList() }
        assertTrue(objectCs.isNotEmpty())

        val objectXs = client.getOfficePets().asSequence().toList()
        assertTrue(objectXs.isNotEmpty())
        val objectYIds = objectXs.flatMap { client.getPetToysForOfficePet(it.id).asSequence().toList() }
        assertTrue(objectYIds.isNotEmpty())
        val objectYs = objectYIds.map { client.getPetToy(it) }
        assertTrue(objectYs.isNotEmpty())
    }
}