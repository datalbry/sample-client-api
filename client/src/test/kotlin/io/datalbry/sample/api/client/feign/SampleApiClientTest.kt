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
        val objectAIds = client.getObjectAIds().asSequence().toList()
        val objectAs = objectAIds.map { client.getObjectA(it) }
        assertTrue(objectAIds.isNotEmpty())
        val objectBIds = objectAIds.flatMap { client.getObjectBIds(it).asSequence().toList() }
        assertTrue(objectBIds.isNotEmpty())
        val objectBs = objectBIds.map { client.getObjectB(it) }
        val objectCs = objectAIds.flatMap { client.getObjectCs(it).asSequence().toList() }
        assertTrue(objectCs.isNotEmpty())

        val objectXs = client.getObjectXs().asSequence().toList()
        assertTrue(objectXs.isNotEmpty())
        val objectYIds = objectXs.flatMap { client.getObjectYIds(it.id).asSequence().toList() }
        assertTrue(objectYIds.isNotEmpty())
        val objectYs = objectYIds.map { client.getObjectY(it) }
        assertTrue(objectYs.isNotEmpty())
    }
}