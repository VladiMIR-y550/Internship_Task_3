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

    @Binds
    fun bindRoomUserListDataSourceToUserListLocalDataSource(
        roomUserListDataSource: RoomUserListDataSource
    ): UserListLocalDataSource

    @Binds
    fun bindRetrofitUserListDataSourceToUserListRemoteDataSource(
        retrofitUserListDataSource: RetrofitUserListDataSource
    ): UserListRemoteDataSource

    @Binds
    fun bindUsersRepositoryToUsersListRepository(
        usersListRepository: UsersListRepository
    ): UsersRepository
}