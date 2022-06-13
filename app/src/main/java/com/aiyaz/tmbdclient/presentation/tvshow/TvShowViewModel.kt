package com.aiyaz.tmbdclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aiyaz.tmbdclient.domain.usecase.GetTvUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShowList() = liveData {
        val tvShowList = getTvUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShowList() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }

}