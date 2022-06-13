package com.aiyaz.tmbdclient.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aiyaz.tmbdclient.domain.usecase.GetPeopleUseCase
import com.aiyaz.tmbdclient.domain.usecase.UpdatePeopleUseCase

class PeopleViewModelFactory(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: UpdatePeopleUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PeopleViewModel(getPeopleUseCase,updatePeopleUseCase) as T
    }
}