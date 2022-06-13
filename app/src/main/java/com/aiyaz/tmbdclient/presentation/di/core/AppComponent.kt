package com.aiyaz.tmbdclient.presentation.di.core

import com.aiyaz.tmbdclient.presentation.di.movie.MovieSubComponent
import com.aiyaz.tmbdclient.presentation.di.people.PeopleSubComponent
import com.aiyaz.tmbdclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun peopleSubComponent(): PeopleSubComponent.Factory

}