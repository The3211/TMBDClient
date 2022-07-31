package com.aiyaz.tmbdclient.data.repository.people

import com.aiyaz.tmbdclient.data.model.people.People
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleCacheDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleLocalDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleRemoteDataSource
import com.aiyaz.tmbdclient.domain.repository.PeopleRepository

class PeopleRepositoryImpl(
    private val peopleCacheDataSource: PeopleCacheDataSource,
    private val peopleLocalDataSource: PeopleLocalDataSource,
    private val peopleRemoteDataSource: PeopleRemoteDataSource
): PeopleRepository {
    override suspend fun getPeopleList(): List<People> {
        return getPeopleFromCache()
    }

    override suspend fun updatePeopleList(): List<People> {
        val newPeopleList = getPeopleListFromApi()
        peopleLocalDataSource.clearAll()
        peopleLocalDataSource.savePeopletoDB(newPeopleList)
        peopleCacheDataSource.savePeopleToCache(newPeopleList)
        return newPeopleList
    }

    suspend fun getPeopleListFromApi(): List<People>{
        lateinit var peopleList: List<People>
        try{
            val response = peopleRemoteDataSource.getPeopleList()
            val body = response.body()
            if(body != null){
                peopleList = body.people
            }
        }catch (e: Exception){

        }
        return peopleList
    }

    suspend fun getPeopleListFromDB(): List<People>{
        lateinit var peopleList: List<People>
        try{
            peopleList = peopleLocalDataSource.getPeopleList()
        }catch (exception: Exception){

        }

        if(peopleList.isNotEmpty()){
            return peopleList
        }else{
            peopleList = getPeopleListFromApi()
            peopleLocalDataSource.savePeopletoDB(peopleList)
        }
        return peopleList
    }

    suspend fun getPeopleFromCache(): List<People>{
        lateinit var peopleList: List<People>
        try{
            peopleList = peopleCacheDataSource.getCachedPeopleList()
        }catch (e: Exception){

        }
        if(peopleList.isNotEmpty()){
            return peopleList
        }else{
            peopleList = getPeopleListFromDB()
            peopleCacheDataSource.savePeopleToCache(peopleList)
        }
        return peopleList
    }

}