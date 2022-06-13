package com.aiyaz.tmbdclient.data.repository.people.datasourceImpl

import com.aiyaz.tmbdclient.data.DB.PeopleDao
import com.aiyaz.tmbdclient.data.model.people.People
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleLocalDataSourceImpl(private val peopleDao: PeopleDao): PeopleLocalDataSource {
    override suspend fun getPeopleList(): List<People> = peopleDao.getAllPeopleData()

    override suspend fun savePeopletoDB(peoples: List<People>) {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.savePeoples(peoples)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            peopleDao.deleteAllPeopleData()
        }
    }
}