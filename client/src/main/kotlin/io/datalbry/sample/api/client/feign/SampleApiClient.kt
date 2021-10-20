package io.datalbry.sample.api.client.feign

import io.datalbry.sample.api.client.PersonEndpointClient
import io.datalbry.sample.api.client.OfficePetEndpointClient

class SampleApiClient(
    val objectAEndpointClient: PersonEndpointClient,
    val objectXEndpointClient: OfficePetEndpointClient,
) :
    PersonEndpointClient by objectAEndpointClient,
    OfficePetEndpointClient by objectXEndpointClient
