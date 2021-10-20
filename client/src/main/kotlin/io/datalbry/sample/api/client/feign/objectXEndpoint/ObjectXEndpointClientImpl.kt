package io.datalbry.sample.api.client.feign.objectAEndpoint

import io.datalbry.sample.api.client.ObjectXEndpointClient
import io.datalbry.sample.api.client.feign.baseEndpoint.ObjectXEndpointFeignResource
import io.datalbry.sample.api.client.model.ObjectX
import io.datalbry.sample.api.client.model.ObjectY
import io.datalbry.sample.api.client.model.ObjectYId

class ObjectXEndpointClientImpl(private val feignResource: ObjectXEndpointFeignResource) : ObjectXEndpointClient {
    override fun getObjectXs(): Iterator<ObjectX> {
        return feignResource.getObjectXs().listIterator()
    }

    override fun getObjectYIds(objectXId: String): Iterator<ObjectYId> {
        return feignResource.getObjectYIds(objectXId).listIterator()
    }

    override fun getObjectY(objectYId: ObjectYId): ObjectY {
        return feignResource.getObjectY(xId = objectYId.xId, yId = objectYId.id)
    }
}