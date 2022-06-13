package com.aiyaz.tmbdclient.data.repository.tvshow.datasourceImpl

import com.aiyaz.tmbdclient.data.DB.TvShowDao
import com.aiyaz.tmbdclient.data.model.tvshow.TVShow
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShow(): List<TVShow> = tvShowDao.getAllTvShow()

    override suspend fun setTvShow(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearTvShow() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}