package com.aiyaz.tmbdclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aiyaz.tmbdclient.domain.usecase.GetMoviesUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }

}