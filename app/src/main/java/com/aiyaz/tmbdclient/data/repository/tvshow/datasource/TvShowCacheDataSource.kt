package com.aiyaz.tmbdclient.data.repository.tvshow.datasource

import com.aiyaz.tmbdclient.data.model.tvshow.TVShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache(): List<TVShow>
    suspend fun saveTvShowToCache(tvShows: List<TVShow>)

}