package com.mironenko.internship_task_3.data.model.remote

import retrofit2.Response

interface UserListRemoteDataSource {
    suspend fun downloadUserList(): Response<UserListResponse>
}