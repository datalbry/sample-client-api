package io.datalbry.sample.api.client.feign.baseEndpoint

import feign.Param
import feign.RequestLine
import io.datalbry.sample.api.client.model.*

interface PersonEndpointFeignResource {

    @RequestLine("GET /api/v1/persons")
    fun getPersonIds(): List<PersonId>

    @RequestLine("GET /api/v1/person/{id}")
    fun getPerson(
        @Param("id") id: String
    ): Person

    @RequestLine("GET /api/v1/person/{id}/computers")
    fun getComputersByPerson(
        @Param("id") id: String
    ): List<ComputerId>

    @RequestLine("GET /api/v1/person/{person_id}/computer/{computer_id}")
    fun getComputer(
        @Param("person_id") person_id: String,
        @Param("computer_id") computer_id: String
    ): Computer

    @RequestLine("GET /api/v1/person/{id}/projects")
    fun getProjects(
        @Param("id") id: String
    ): List<Project>

}