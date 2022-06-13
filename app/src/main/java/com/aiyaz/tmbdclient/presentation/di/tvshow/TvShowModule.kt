package com.aiyaz.tmbdclient.presentation.di.tvshow

import com.aiyaz.tmbdclient.domain.usecase.GetTvUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdateTvShowUseCase
import com.aiyaz.tmbdclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvUseCase: GetTvUseCase,
                                      updateTvShowUseCase: UpdateTvShowUseCase): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvUseCase, updateTvShowUseCase)
    }

}