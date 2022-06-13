package com.aiyaz.tmbdclient.domain.repository

import com.aiyaz.tmbdclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}