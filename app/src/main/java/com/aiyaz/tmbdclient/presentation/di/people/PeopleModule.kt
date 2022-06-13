package com.aiyaz.tmbdclient.presentation.di.people

import com.aiyaz.tmbdclient.domain.usecase.GetPeopleUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdatePeopleUseCase
import com.aiyaz.tmbdclient.presentation.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PeopleModule {

    @PeopleScope
    @Provides
    fun provideArtistViewModelFactory(getPeopleUseCase: GetPeopleUseCase
                                      ,updatePeopleUseCase: UpdatePeopleUseCase): PeopleViewModelFactory{
        return PeopleViewModelFactory(getPeopleUseCase,updatePeopleUseCase)
    }



}