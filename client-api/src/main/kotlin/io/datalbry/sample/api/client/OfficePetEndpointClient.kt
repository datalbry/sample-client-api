package io.datalbry.sample.api.client

import io.datalbry.sample.api.client.model.*

interface OfficePetEndpointClient {

    fun getOfficePets(): Iterator<OfficePet>
    fun getPetToysForOfficePet(petId: String): Iterator<PetToyId>
    fun getPetToy(petToyId: PetToyId): PetToy

}