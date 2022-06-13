package com.aiyaz.tmbdclient.data.repository.movie.datasourceImpl

import com.aiyaz.tmbdclient.data.model.movie.Movie
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}