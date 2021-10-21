package io.datalbry.sample.api.client.feign.officePetEndpoint

import feign.Param
import feign.RequestLine
import io.datalbry.sample.api.client.model.*

interface OfficePetEndpointFeignResource {


    @RequestLine("GET /api/v1/officePets")
    fun getOfficePets(): List<OfficePet>

    @RequestLine("GET /api/v1/officePet/{id}/petToys")
    fun getPetToysForOfficePet(
        @Param("id") id: String
    ): List<PetToyId>

    @RequestLine("GET /api/v1/officePet/{pet_id}/petToy/{toy_id}")
    fun getPetToy(
        @Param("pet_id") pet_id: String,
        @Param("toy_id") toy_id: String,
    ): PetToy

}