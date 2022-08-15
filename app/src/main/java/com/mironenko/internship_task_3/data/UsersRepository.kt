package com.mironenko.internship_task_3.data

interface UsersRepository {
    suspend fun getUserList(): List<User>
    suspend fun getUserById(userId: String): User
}