package io.datalbry.sample.api.client.feign

import io.datalbry.sample.api.client.ObjectAEndpointClient
import io.datalbry.sample.api.client.ObjectXEndpointClient

class SampleApiClient(
    val objectAEndpointClient: ObjectAEndpointClient,
    val objectXEndpointClient: ObjectXEndpointClient,
) :
    ObjectAEndpointClient by objectAEndpointClient,
    ObjectXEndpointClient by objectXEndpointClient
