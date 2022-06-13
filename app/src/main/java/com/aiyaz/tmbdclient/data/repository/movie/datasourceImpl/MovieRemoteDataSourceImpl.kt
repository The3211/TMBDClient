package com.aiyaz.tmbdclient.data.repository.movie.datasourceImpl

import com.aiyaz.tmbdclient.data.api.TMDBService
import com.aiyaz.tmbdclient.data.model.movie.MovieList
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDataSource {
    override suspend fun getMovies() : Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}