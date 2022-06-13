package com.aiyaz.tmbdclient.data.repository.movie.datasource

import com.aiyaz.tmbdclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}