package com.aiyaz.tmbdclient.domain.repository

import com.aiyaz.tmbdclient.data.model.people.People

interface PeopleRepository {

    suspend fun getPeopleList(): List<People>?

    suspend fun updatePeopleList(): List<People>?
}