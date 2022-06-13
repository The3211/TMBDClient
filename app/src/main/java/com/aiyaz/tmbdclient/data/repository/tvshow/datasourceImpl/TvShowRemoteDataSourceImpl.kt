package com.aiyaz.tmbdclient.data.repository.tvshow.datasourceImpl

import com.aiyaz.tmbdclient.data.api.TMDBService
import com.aiyaz.tmbdclient.data.model.tvshow.TVShowList
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey: String):TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TVShowList> = tmdbService.getPopularTVShow(apiKey)
}