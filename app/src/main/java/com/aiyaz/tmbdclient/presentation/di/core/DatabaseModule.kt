package com.aiyaz.tmbdclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.aiyaz.tmbdclient.data.DB.MovieDao
import com.aiyaz.tmbdclient.data.DB.PeopleDao
import com.aiyaz.tmbdclient.data.DB.TMDBDatabase
import com.aiyaz.tmbdclient.data.DB.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovideDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun providePeopleDao(tmdbDatabase: TMDBDatabase): PeopleDao{
        return tmdbDatabase.peopleDao()
    }

}