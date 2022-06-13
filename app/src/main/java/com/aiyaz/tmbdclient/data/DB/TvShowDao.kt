package com.aiyaz.tmbdclient.data.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aiyaz.tmbdclient.data.model.tvshow.TVShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TVShow>)

    @Query("delete from popular_tvshows")
    suspend fun deleteAllTvShow()

    @Query("select * from popular_tvshows")
    suspend fun getAllTvShow(): List<TVShow>
}