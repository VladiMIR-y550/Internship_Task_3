package com.mironenko.internship_task_3.util.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import com.mironenko.internship_task_3.ui.list.UserListViewModel
import javax.inject.Inject

class UserListViewModelFactory @Inject constructor(private var repository: UsersRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserListViewModel(
            setOf(
                GetUsersInteractor(repository = repository)
            )
        ) as T
    }
}