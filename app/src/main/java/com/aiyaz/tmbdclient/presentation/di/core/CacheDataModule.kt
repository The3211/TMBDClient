package com.aiyaz.tmbdclient.presentation.di.core

import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.aiyaz.tmbdclient.data.repository.people.datasource.PeopleCacheDataSource
import com.aiyaz.tmbdclient.data.repository.people.datasourceImpl.PeopleCacheDataSourceImpl
import com.aiyaz.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.aiyaz.tmbdclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providePeopleCacheDataSource(): PeopleCacheDataSource{
        return PeopleCacheDataSourceImpl()
    }

}