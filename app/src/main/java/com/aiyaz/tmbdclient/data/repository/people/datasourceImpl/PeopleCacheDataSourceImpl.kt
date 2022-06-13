package com.aiyaz.tmbdclient.data.repository.people.datasourceImpl

import com.aiyaz.tmbdclient.data.model.people.People
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleCacheDataSource

class PeopleCacheDataSourceImpl(): PeopleCacheDataSource {

    private var peopleList = ArrayList<People>()

    override suspend fun getCachedPeopleList(): List<People> = peopleList

    override suspend fun savePeopleToCache(peoples: List<People>) {
        peopleList.clear()
        peopleList = ArrayList(peoples)
    }
}