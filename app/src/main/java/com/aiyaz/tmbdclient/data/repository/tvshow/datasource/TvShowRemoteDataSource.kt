package com.aiyaz.tmbdclient.data.repository.tvshow.datasource

import com.aiyaz.tmbdclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TVShowList>
}