package io.datalbry.sample.api.client

import io.datalbry.sample.api.client.model.*

interface ObjectAEndpointClient {

    fun getObjectAIds(): Iterator<ObjectAId>
    fun getObjectA(objectAId: ObjectAId): ObjectA
    fun getObjectBIds(objectAId: ObjectAId): Iterator<ObjectBId>
    fun getObjectB(objectBId: ObjectBId): ObjectB
    fun getObjectCs(objectAId: ObjectAId): Iterator<ObjectC>
}