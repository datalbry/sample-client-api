package io.datalbry.sample.api.client.feign.personEndpoint

import io.datalbry.sample.api.client.OfficePetEndpointClient
import io.datalbry.sample.api.client.feign.baseEndpoint.OfficePetEndpointFeignResource
import io.datalbry.sample.api.client.model.OfficePet
import io.datalbry.sample.api.client.model.PetToy
import io.datalbry.sample.api.client.model.PetToyId

class OfficePetEndpointClientImpl(private val feignResource: OfficePetEndpointFeignResource) : OfficePetEndpointClient {
    override fun getOfficePets(): Iterator<OfficePet> {
        return feignResource.getOfficePets().listIterator()
    }

    override fun getPetToysForOfficePet(petId: String): Iterator<PetToyId> {
        return feignResource.getPetToysForOfficePet(petId).listIterator()
    }

    override fun getPetToy(petToyId: PetToyId): PetToy {
        return feignResource.getPetToy(pet_id = petToyId.petId, toy_id = petToyId.id)
    }
}