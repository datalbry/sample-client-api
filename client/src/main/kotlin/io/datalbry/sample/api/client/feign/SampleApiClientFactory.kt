package io.datalbry.sample.api.client.feign

import io.datalbry.sample.api.client.feign.personEndpoint.PersonEndpointClientImpl
import io.datalbry.sample.api.client.feign.extensions.build
import io.datalbry.sample.api.client.feign.extensions.defaultBuilder
import io.datalbry.sample.api.client.feign.officePetEndpoint.OfficePetEndpointClientImpl


/**
 * The [SampleApiClientFactory] builds with the config the SampleApiClient with all it's parts and feign resources
 * initialized.
 */
class SampleApiClientFactory {

    fun create(config: SampleApiClientConfig): SampleApiClient {
        val builder = defaultBuilder
        return SampleApiClient(
            PersonEndpointClientImpl(builder.build(config)),
            OfficePetEndpointClientImpl(builder.build(config)),
        )
    }
}