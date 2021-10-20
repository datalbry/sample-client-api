package io.datalbry.sample.api.client.feign.extensions

import feign.Feign
import feign.httpclient.ApacheHttpClient
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.slf4j.Slf4jLogger
import io.datalbry.sample.api.client.feign.SampleApiClientConfig

/**
 * Default instance of the Feign Builder, preconfigured with Jackson decoder and encoder
 */
val defaultBuilder: Feign.Builder = Feign
    .Builder()
    .decoder(JacksonDecoder(jackson()))
    .encoder(JacksonEncoder(jackson()))
    .client(ApacheHttpClient())

/**
 * Extension function for the Feign.Builder, enabling building of interfaces just by their type
 *
 * @param config of the SampleApi instance
 * @param FeignDefinition to build
 *
 * @return Created instance of type FeignDefinition
 */
inline fun <reified FeignDefinition> Feign.Builder.build(config: SampleApiClientConfig): FeignDefinition {
    this.logger(Slf4jLogger(FeignDefinition::class.java))
    return this.target(FeignDefinition::class.java, config.uri.toString())
}
