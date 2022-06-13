package com.aiyaz.tmbdclient.data.repository.movie.datasource

import com.aiyaz.tmbdclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun getMoviesFromCache(): List<Movie>
}