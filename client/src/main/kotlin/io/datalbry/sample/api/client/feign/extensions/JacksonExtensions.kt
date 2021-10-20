package io.datalbry.sample.api.client.feign.extensions

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


/**
 * Static function to create a Jackson [ObjectMapper] preconfigured
 * with JDK8Module, to provide Optional handling, as well as disabling FAIL_ON_UNKNOWN_PROPERTIES
 *
 * @return newly created [ObjectMapper]
 *
 * @author timo gruen - 2021-01-06
 */
fun jackson(): ObjectMapper {
    val mapper = jacksonObjectMapper()
    mapper.registerModule(Jdk8Module())
    mapper.registerModule(JavaTimeModule())
    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
    mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    return mapper
}
