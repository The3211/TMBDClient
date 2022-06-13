package com.aiyaz.tmbdclient.data.repository.people.datasource

import com.aiyaz.tmbdclient.data.model.people.People

interface PeopleLocalDataSource {

    suspend fun getPeopleList(): List<People>
    suspend fun savePeopletoDB(peoples: List<People>)
    suspend fun clearAll()

}