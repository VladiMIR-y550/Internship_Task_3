package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.data.mapper.EntityMapper
import com.mironenko.internship_task_3.data.mapper.UsersMapper
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.UserResponse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface MapperBindingsModule {
    @Binds
    fun bindMapper(impl: UsersMapper): EntityMapper<UserResponse, UserDbEntity, User>
}