package com.aiyaz.tmbdclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aiyaz.tmbdclient.domain.usecase.GetTvUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvUseCase,updateTvShowUseCase) as T
    }
}