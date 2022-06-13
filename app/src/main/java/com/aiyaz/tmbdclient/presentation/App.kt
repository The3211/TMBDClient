package com.aiyaz.tmbdclient.presentation

import android.app.Application
import com.aiyaz.tmbdclient.BuildConfig
import com.aiyaz.tmbdclient.presentation.di.Injector
import com.aiyaz.tmbdclient.presentation.di.core.*
import com.aiyaz.tmbdclient.presentation.di.movie.MovieSubComponent
import com.aiyaz.tmbdclient.presentation.di.people.PeopleSubComponent
import com.aiyaz.tmbdclient.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createPeopleSubComponent(): PeopleSubComponent {
        return appComponent.peopleSubComponent().create()
    }

}