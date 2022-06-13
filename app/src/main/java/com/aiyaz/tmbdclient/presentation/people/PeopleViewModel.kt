package com.aiyaz.tmbdclient.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aiyaz.tmbdclient.domain.usecase.GetPeopleUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdatePeopleUseCase

class PeopleViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: UpdatePeopleUseCase
): ViewModel() {


    fun getTvShowList() = liveData {
        val tvShowList = getPeopleUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShowList() = liveData {
        val tvShowList = updatePeopleUseCase.execute()
        emit(tvShowList)
    }

}