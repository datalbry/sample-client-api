package io.datalbry.sample.api.client.feign.baseEndpoint

import feign.Param
import feign.RequestLine
import io.datalbry.sample.api.client.model.*

interface ObjectXEndpointFeignResource {


    @RequestLine("GET /api/v1/objectXs")
    fun getObjectXs(): List<ObjectX>

    @RequestLine("GET /api/v1/objectX/{id}/objectYs")
    fun getObjectYIds(
        @Param("id") id: String
    ): List<ObjectYId>

    @RequestLine("GET /api/v1/objectX/{xId}/objectY/{yId}")
    fun getObjectY(
        @Param("xId") xId: String,
        @Param("yId") yId: String,
    ): ObjectY

}