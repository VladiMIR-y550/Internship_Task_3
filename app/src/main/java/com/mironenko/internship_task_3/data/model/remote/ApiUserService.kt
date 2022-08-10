package com.mironenko.internship_task_3.data.model.remote

import com.mironenko.internship_task_3.util.AMOUNT_DOWNLOAD_PAGE
import com.mironenko.internship_task_3.util.START_PAGE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUserService {

    @GET("api/")
    suspend fun downloadUser(
        @Query("page") pageNum: Int = START_PAGE,
        @Query("results") results: Int = AMOUNT_DOWNLOAD_PAGE,
        @Query("seed") seed: String = "abc"
    ): Response<UserListResponse>
}