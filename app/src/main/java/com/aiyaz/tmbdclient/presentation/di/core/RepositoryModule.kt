package com.aiyaz.tmbdclient.presentation.di.core

import com.aiyaz.tmbdclient.data.repository.movie.MovieRepositoryImpl
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieLocalDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.aiyaz.tmbdclient.data.repository.people.PeopleRepositoryImpl
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleCacheDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleLocalDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleRemoteDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.TvShowRepositoryImpl
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.aiyaz.tmbdclient.domain.repository.MovieRepository
import com.aiyaz.tmbdclient.domain.repository.PeopleRepository
import com.aiyaz.tmbdclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvshowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowRepository{
        return TvShowRepositoryImpl(tvShowCacheDataSource,tvshowRemoteDataSource,tvShowLocalDataSource)
    }

    @Provides
    @Singleton
    fun providePeopleRepository(
        peopleRemoteDataSource: PeopleRemoteDataSource,
        peopleLocalDataSource: PeopleLocalDataSource,
        peopleCacheDataSource: PeopleCacheDataSource
    ): PeopleRepository{
        return PeopleRepositoryImpl(peopleCacheDataSource,peopleLocalDataSource,peopleRemoteDataSource)
    }

}