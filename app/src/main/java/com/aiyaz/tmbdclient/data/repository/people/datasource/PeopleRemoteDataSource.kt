package com.aiyaz.tmbdclient.data.repository.people.datasource

import com.aiyaz.tmbdclient.data.model.people.PeopleList
import retrofit2.Response


interface PeopleRemoteDataSource {
    suspend fun getPeopleList(): Response<PeopleList>
}