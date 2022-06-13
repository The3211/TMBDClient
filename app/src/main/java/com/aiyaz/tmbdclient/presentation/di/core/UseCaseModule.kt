package com.aiyaz.tmbdclient.presentation.di.core

import com.aiyaz.tmbdclient.domain.repository.MovieRepository
import com.aiyaz.tmbdclient.domain.repository.PeopleRepository
import com.aiyaz.tmbdclient.domain.repository.TvShowRepository
import com.aiyaz.tmbdclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvUseCase{
        return GetTvUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun providesUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun providesGetPropleUseCase(peopleRepository: PeopleRepository): GetPeopleUseCase{
        return GetPeopleUseCase(peopleRepository)
    }

    @Singleton
    @Provides
    fun providesUpdatePeopleUseCase(peopleRepository: PeopleRepository): UpdatePeopleUseCase{
        return UpdatePeopleUseCase(peopleRepository)
    }

}