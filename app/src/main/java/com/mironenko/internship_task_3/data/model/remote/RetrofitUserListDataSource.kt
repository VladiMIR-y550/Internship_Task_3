package com.mironenko.internship_task_3.data.model.remote

class RetrofitUserListDataSource(
    private val apiUserService: ApiUserService
) : UserListRemoteDataSource {

    override suspend fun downloadUserList(): UserListResponse = apiUserService.downloadUser()
}