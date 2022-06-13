package com.aiyaz.tmbdclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aiyaz.tmbdclient.domain.usecase.GetMoviesUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMovieUseCase) as T
    }
}