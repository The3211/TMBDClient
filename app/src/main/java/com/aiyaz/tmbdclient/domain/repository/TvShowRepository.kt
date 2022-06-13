package com.aiyaz.tmbdclient.domain.repository

import com.aiyaz.tmbdclient.data.model.tvshow.TVShow

interface TvShowRepository {

    suspend fun getTvShow(): List<TVShow>?

    suspend fun updateTvShow(): List<TVShow>?

}