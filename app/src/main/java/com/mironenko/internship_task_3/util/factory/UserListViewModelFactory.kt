package com.mironenko.internship_task_3.util.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import com.mironenko.internship_task_3.ui.list.UserListViewModel

class UserListViewModelFactory(application: Application) : BaseViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(
            setOf(
                GetUsersInteractor(repository = repository)
            )
        ) as T
    }
}