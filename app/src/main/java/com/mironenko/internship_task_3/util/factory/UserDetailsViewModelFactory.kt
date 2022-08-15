package com.mironenko.internship_task_3.util.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.ui.details.UserDetailsViewModel

class UserDetailsViewModelFactory(application: Application, private val userId: String) :
    BaseViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailsViewModel(
            setOf(GetUserByIdInteractor(repository = repository)),
            userId = userId
        ) as T
    }
}