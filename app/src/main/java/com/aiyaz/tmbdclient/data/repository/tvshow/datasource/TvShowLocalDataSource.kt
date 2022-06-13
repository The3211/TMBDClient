package com.aiyaz.tmbdclient.data.repository.tvshow.datasource

import com.aiyaz.tmbdclient.data.model.tvshow.TVShow

interface TvShowLocalDataSource {

    suspend fun getTvShow(): List<TVShow>
    suspend fun setTvShow(tvShows: List<TVShow>)
    suspend fun clearTvShow()

}