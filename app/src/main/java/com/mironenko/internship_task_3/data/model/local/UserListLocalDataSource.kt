package com.mironenko.internship_task_3.data.model.local

import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity

interface UserListLocalDataSource {

    suspend fun getAllUsers(): List<UserDbEntity>

    suspend fun getUserDbEntityById(userId: String): UserDbEntity

    suspend fun saveUserToDataBase(userDbEntity: UserDbEntity)
}