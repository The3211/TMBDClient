package com.aiyaz.tmbdclient.presentation.di.core

import android.content.Context
import com.aiyaz.tmbdclient.presentation.di.movie.MovieSubComponent
import com.aiyaz.tmbdclient.presentation.di.people.PeopleSubComponent
import com.aiyaz.tmbdclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,PeopleSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }

}