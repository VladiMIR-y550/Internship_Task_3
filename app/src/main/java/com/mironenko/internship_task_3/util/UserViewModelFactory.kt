package com.mironenko.internship_task_3.util

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mironenko.internship_task_3.UserApp
import com.mironenko.internship_task_3.apiUserService
import com.mironenko.internship_task_3.data.UsersListRepository
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import com.mironenko.internship_task_3.data.model.local.RoomUserListDataSource
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.remote.RetrofitUserListDataSource
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource
import com.mironenko.internship_task_3.ui.details.UserDetailsViewModel
import com.mironenko.internship_task_3.ui.list.UserListViewModel
import com.mironenko.internship_task_3.usersRoomDataBase

fun Fragment.factory(itemId: String = ""): UserViewModelFactory =
    UserViewModelFactory(requireContext().applicationContext as UserApp, itemId = itemId)

class UserViewModelFactory(private val application: Application, private val itemId: String) :
    ViewModelProvider.Factory {

    private val localDataSource: UserListLocalDataSource =
        RoomUserListDataSource(application.usersRoomDataBase.getUsersListDao())
    private val remoteDataSource: UserListRemoteDataSource =
        RetrofitUserListDataSource(application.apiUserService)
    private val repository: UsersRepository = UsersListRepository(remoteDataSource, localDataSource)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            UserListViewModel::class.java -> {
                UserListViewModel(setOf(GetUsersInteractor(repository = repository)))
            }

            UserDetailsViewModel::class.java -> {
                UserDetailsViewModel(
                    setOf(GetUserByIdInteractor(repository = repository)),
                    itemId = itemId
                )
            }

            else -> {
                throw IllegalStateException("Unknown viewModel class")
            }
        }
        return viewModel as T
    }
}