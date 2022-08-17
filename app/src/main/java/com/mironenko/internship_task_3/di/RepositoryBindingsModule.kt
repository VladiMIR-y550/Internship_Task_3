package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.UsersListRepository
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.model.local.RoomUserListDataSource
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.remote.RetrofitUserListDataSource
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface RepositoryBindingsModule {

    @Suppress("FunctionName")
    @Binds
    fun bindRoomUserListDataSource_to_UserListLocalDataSource(
        roomUserListDataSource: RoomUserListDataSource
    ): UserListLocalDataSource

    @Suppress("FunctionName")
    @Binds
    fun bindRetrofitUserListDataSource_to_UserListRemoteDataSource(
        retrofitUserListDataSource: RetrofitUserListDataSource
    ): UserListRemoteDataSource

    @Suppress("FunctionName")
    @Binds
    fun bindUsersRepository_to_UsersListRepository(
        usersListRepository: UsersListRepository
    ): UsersRepository
}