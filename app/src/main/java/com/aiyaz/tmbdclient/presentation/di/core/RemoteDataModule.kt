package com.aiyaz.tmbdclient.presentation.di.core

import com.aiyaz.tmbdclient.data.api.TMDBService
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleRemoteDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasourceImpl.PeopleRemoteDataSourceImpl
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }


    @Singleton
    @Provides
    fun providePeopleDataSource(tmdbService: TMDBService): PeopleRemoteDataSource {
        return PeopleRemoteDataSourceImpl(tmdbService, apiKey)
    }


}