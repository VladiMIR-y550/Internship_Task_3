package com.mironenko.internship_task_3.data

import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity

interface UsersRepository {
    suspend fun getUserList(): List<UserDbEntity>
    suspend fun getUserById(userId: String): UserDbEntity
}