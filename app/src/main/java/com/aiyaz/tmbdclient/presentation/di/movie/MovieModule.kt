package com.aiyaz.tmbdclient.presentation.di.movie

import com.aiyaz.tmbdclient.domain.usecase.GetMoviesUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdateMovieUseCase
import com.aiyaz.tmbdclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMovieUseCase: GetMoviesUseCase,
                                     updateMovieUseCase: UpdateMovieUseCase): MovieViewModelFactory{
        return MovieViewModelFactory(getMovieUseCase,updateMovieUseCase)
    }

}