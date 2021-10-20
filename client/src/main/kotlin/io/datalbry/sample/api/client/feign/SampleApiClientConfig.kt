package io.datalbry.sample.api.client.feign

import java.net.URI

/**
 * The [SampleApiClientConfig] is right now the only configuration object. Currently, it contains only the URI of the
 * target system, but it could also contain credentials like an API key.
 */
data class SampleApiClientConfig(
    val uri: URI
)
