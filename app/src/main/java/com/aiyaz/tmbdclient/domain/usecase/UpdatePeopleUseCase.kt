package com.aiyaz.tmbdclient.domain.usecase

import com.aiyaz.tmbdclient.data.model.people.People
import com.aiyaz.tmbdclient.domain.repository.PeopleRepository

class UpdatePeopleUseCase(private val peopleRepository: PeopleRepository) {
    suspend fun execute(): List<People>? = peopleRepository.updatePeopleList()
}