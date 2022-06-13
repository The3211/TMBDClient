package com.aiyaz.tmbdclient.data.repository.people.datasourceImpl

import com.aiyaz.tmbdclient.data.api.TMDBService
import com.aiyaz.tmbdclient.data.model.people.PeopleList
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleRemoteDataSource
import retrofit2.Response

class PeopleRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): PeopleRemoteDataSource {
    override suspend fun getPeopleList(): Response<PeopleList> = tmdbService.getPopularPeople(apiKey)
}