package com.mironenko.internship_task_3.util.factory

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.mironenko.internship_task_3.apiUserService
import com.mironenko.internship_task_3.data.UsersListRepository
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.mapper.UsersMapper
import com.mironenko.internship_task_3.data.model.local.RoomUserListDataSource
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.remote.RetrofitUserListDataSource
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource
import com.mironenko.internship_task_3.usersRoomDataBase

abstract class BaseViewModelFactory(application: Application) : ViewModelProvider.Factory {
    private val localDataSource: UserListLocalDataSource =
        RoomUserListDataSource(application.usersRoomDataBase.getUsersListDao())
    private val remoteDataSource: UserListRemoteDataSource =
        RetrofitUserListDataSource(application.apiUserService)
    private val responseMapper = UsersMapper()
    protected val repository: UsersRepository =
        UsersListRepository.getInstance(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource,
            mapper = responseMapper
        )!!
}