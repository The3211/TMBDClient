package com.aiyaz.tmbdclient.data.repository.people.datasource

import com.aiyaz.tmbdclient.data.model.people.People

interface PeopleCacheDataSource {

    suspend fun getCachedPeopleList(): List<People>
    suspend fun savePeopleToCache(peoples: List<People>)

}