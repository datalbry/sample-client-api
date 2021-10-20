package io.datalbry.sample.api.client.feign.baseEndpoint

import feign.Param
import feign.RequestLine
import io.datalbry.sample.api.client.model.*

interface ObjectAEndpointFeignResource {

    @RequestLine("GET /api/v1/objectAs")
    fun getObjectAIds(): List<ObjectAId>

    @RequestLine("GET /api/v1/objectA/{id}")
    fun getObjectA(
        @Param("id") id: String
    ): ObjectA

    @RequestLine("GET /api/v1/objectA/{id}/objectBs")
    fun getObjectBIds(
        @Param("id") id: String
    ): List<ObjectBId>

    @RequestLine("GET /api/v1/objectA/{aId}/objectB/{bId}")
    fun getObjectB(
        @Param("aId") aId: String,
        @Param("bId") bId: String
    ): ObjectB

    @RequestLine("GET /api/v1/objectA/{id}/objectCs")
    fun getObjectCs(
        @Param("id") id: String
    ): List<ObjectC>

}