package com.aiyaz.tmbdclient.presentation.di

import com.aiyaz.tmbdclient.presentation.di.movie.MovieSubComponent
import com.aiyaz.tmbdclient.presentation.di.people.PeopleSubComponent
import com.aiyaz.tmbdclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createPeopleSubComponent(): PeopleSubComponent
}