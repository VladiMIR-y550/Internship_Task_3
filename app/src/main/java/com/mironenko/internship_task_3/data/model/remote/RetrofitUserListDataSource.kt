package com.mironenko.internship_task_3.data.model.remote

import retrofit2.Response

class RetrofitUserListDataSource(private val apiUserService: ApiUserService) :
    UserListRemoteDataSource {
    override suspend fun downloadUserList(

    ): Response<UserListResponse> =
        apiUserService.downloadUser()
}