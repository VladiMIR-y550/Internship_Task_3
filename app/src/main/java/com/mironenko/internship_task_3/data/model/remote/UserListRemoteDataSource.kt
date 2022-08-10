package com.mironenko.internship_task_3.data.model.remote

interface UserListRemoteDataSource {
    suspend fun downloadUserList(): UserListResponse
}