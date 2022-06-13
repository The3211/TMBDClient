package com.aiyaz.tmbdclient.presentation.di.people

import com.aiyaz.tmbdclient.presentation.people.PeopleActivity
import dagger.Subcomponent

@PeopleScope
@Subcomponent(modules = [PeopleModule::class])
interface PeopleSubComponent {
    fun inject(peopleActivity: PeopleActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): PeopleSubComponent
    }
}