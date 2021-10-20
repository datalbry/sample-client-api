package io.datalbry.sample.api.client.feign.objectAEndpoint

import io.datalbry.sample.api.client.ObjectAEndpointClient
import io.datalbry.sample.api.client.feign.baseEndpoint.ObjectAEndpointFeignResource
import io.datalbry.sample.api.client.model.*

class ObjectAEndpointClientImpl(private val feignResource: ObjectAEndpointFeignResource) : ObjectAEndpointClient {
    override fun getObjectAIds(): Iterator<ObjectAId> {
        return feignResource.getObjectAIds().listIterator()
    }

    override fun getObjectA(objectAId: ObjectAId): ObjectA {
        return feignResource.getObjectA(objectAId.id)
    }

    override fun getObjectBIds(objectAId: ObjectAId): Iterator<ObjectBId> {
        return feignResource.getObjectBIds(objectAId.id).listIterator()
    }

    override fun getObjectB(objectBId: ObjectBId): ObjectB {
        return feignResource.getObjectB(aId = objectBId.aId, bId = objectBId.id)
    }

    override fun getObjectCs(objectAId: ObjectAId): Iterator<ObjectC> {
        return feignResource.getObjectCs(objectAId.id).listIterator()
    }

}