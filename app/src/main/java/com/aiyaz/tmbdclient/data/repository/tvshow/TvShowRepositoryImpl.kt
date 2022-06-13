package com.aiyaz.tmbdclient.data.repository.tvshow

import com.aiyaz.tmbdclient.data.model.tvshow.TVShow
import com.aiyaz.tmbdclient.data.model.tvshow.TVShowList
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.aiyaz.tmbdclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource
): TvShowRepository {
    override suspend fun getTvShow(): List<TVShow> {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShow(): List<TVShow> {
        val newTvShowList = getTvShowFromApi()
        tvShowLocalDataSource.clearTvShow()
        tvShowLocalDataSource.setTvShow(newTvShowList)
        tvShowCacheDataSource.saveTvShowToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowFromApi(): List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try{
            var response = tvShowRemoteDataSource.getTvShow()
            val body: TVShowList? = response.body()
            if(body != null){
                tvShowList = body.TVShows
            }
        }catch (excetpion : Exception){

        }
        return tvShowList
    }


    suspend fun getTvShowFromDB(): List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try{
            tvShowList = tvShowLocalDataSource.getTvShow()
        }catch (exception: Exception){

        }
        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.setTvShow(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try{
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (exception: Exception){

        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

}