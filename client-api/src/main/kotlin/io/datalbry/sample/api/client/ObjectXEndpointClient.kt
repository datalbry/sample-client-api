package io.datalbry.sample.api.client

import io.datalbry.sample.api.client.model.*

interface ObjectXEndpointClient {

    fun getObjectXs(): Iterator<ObjectX>
    fun getObjectYIds(objectXId: String): Iterator<ObjectYId>
    fun getObjectY(objectYId: ObjectYId): ObjectY

}