package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.UsersListRepository
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.model.local.RoomUserListDataSource
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.remote.RetrofitUserListDataSource
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {

    single<UserListLocalDataSource> {
        RoomUserListDataSource(usersDao = get())
    }

    single<UserListRemoteDataSource> {
        RetrofitUserListDataSource(apiUserService = get())
    }

    single<UsersRepository> {
        UsersListRepository(
            remoteDataSource = get(),
            localDataSource = get(),
            mapper = get()
        )
    }
}