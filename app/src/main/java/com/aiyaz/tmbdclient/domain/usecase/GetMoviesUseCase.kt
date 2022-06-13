package com.aiyaz.tmbdclient.domain.usecase

import com.aiyaz.tmbdclient.data.model.movie.Movie
import com.aiyaz.tmbdclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}