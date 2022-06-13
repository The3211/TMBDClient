package com.aiyaz.tmbdclient.presentation.di.core

import com.aiyaz.tmbdclient.data.DB.MovieDao
import com.aiyaz.tmbdclient.data.DB.PeopleDao
import com.aiyaz.tmbdclient.data.DB.TMDBDatabase
import com.aiyaz.tmbdclient.data.DB.TvShowDao
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieLocalDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleLocalDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasourceImpl.PeopleLocalDataSourceImpl
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun providePeopleLocalDataSource(peopleDao: PeopleDao): PeopleLocalDataSource{
        return PeopleLocalDataSourceImpl(peopleDao)
    }



}