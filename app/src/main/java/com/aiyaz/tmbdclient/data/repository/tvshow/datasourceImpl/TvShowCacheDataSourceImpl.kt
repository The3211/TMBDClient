package com.aiyaz.tmbdclient.data.repository.tvshow.datasourceImpl

import com.aiyaz.tmbdclient.data.model.tvshow.TVShow
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTvShowFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTvShowToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}