package com.aiyaz.tmbdclient.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aiyaz.tmbdclient.domain.usecase.GetPeopleUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdatePeopleUseCase

class PeopleViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: UpdatePeopleUseCase
): ViewModel() {


    fun getPeopleList() = liveData {
        val peopleList = getPeopleUseCase.execute()
        emit(peopleList)
    }

    fun updatePeopleList() = liveData {
        val peopleList = updatePeopleUseCase.execute()
        emit(peopleList)
    }

}