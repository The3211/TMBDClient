package com.aiyaz.tmbdclient.data.repository.movie.datasource

import com.aiyaz.tmbdclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}