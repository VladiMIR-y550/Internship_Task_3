package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.data.UsersListRepository
import com.mironenko.internship_task_3.data.mapper.EntityMapper
import com.mironenko.internship_task_3.data.model.local.RoomUserListDataSource
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.local.room.UsersRoomDatabase
import com.mironenko.internship_task_3.data.model.remote.ApiUserService
import com.mironenko.internship_task_3.data.model.remote.RetrofitUserListDataSource
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource
import com.mironenko.internship_task_3.data.model.remote.UserResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRoomUserListDataSource(
        roomDatabase: UsersRoomDatabase
    ): RoomUserListDataSource {
        return RoomUserListDataSource(roomDatabase.getUsersListDao())
    }

    @Provides
    @Singleton
    fun provideRetrofitUserListDataSource(
        apiUserService: ApiUserService
    ): RetrofitUserListDataSource {
        return RetrofitUserListDataSource(apiUserService)
    }

    @Provides
    @Singleton
    fun provideUsersListRepository(
        remoteDataSource: UserListRemoteDataSource,
        localDataSource: UserListLocalDataSource,
        mapper: EntityMapper<UserResponse, UserDbEntity, User>
    ): UsersListRepository {
        return UsersListRepository.getInstance(remoteDataSource, localDataSource, mapper)!!
    }
}