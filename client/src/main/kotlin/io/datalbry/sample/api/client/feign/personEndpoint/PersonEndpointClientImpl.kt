package io.datalbry.sample.api.client.feign.personEndpoint

import io.datalbry.sample.api.client.PersonEndpointClient
import io.datalbry.sample.api.client.model.*

class PersonEndpointClientImpl(private val feignResource: PersonEndpointFeignResource) : PersonEndpointClient {
    override fun getPersonIds(): Iterator<PersonId> {
        return feignResource.getPersonIds().listIterator()
    }

    override fun getPerson(personId: PersonId): Person {
        return feignResource.getPerson(personId.id)
    }

    override fun getComputerIds(personId: PersonId): Iterator<ComputerId> {
        return feignResource.getComputersByPerson(personId.id).listIterator()
    }

    override fun getComputer(computerId: ComputerId): Computer {
        return feignResource.getComputer(person_id = computerId.personId, computer_id = computerId.id)
    }

    override fun getProjects(personId: PersonId): Iterator<Project> {
        return feignResource.getProjects(personId.id).listIterator()
    }

}