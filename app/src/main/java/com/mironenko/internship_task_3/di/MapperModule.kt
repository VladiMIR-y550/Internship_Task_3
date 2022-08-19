package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.User
import com.mironenko.internship_task_3.data.mapper.EntityMapper
import com.mironenko.internship_task_3.data.mapper.UsersMapper
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.UserResponse
import org.koin.dsl.module

val mapperModule = module {

    factory<EntityMapper<UserResponse, UserDbEntity, User>> {
        UsersMapper(dateFormatter = get())
    }
}