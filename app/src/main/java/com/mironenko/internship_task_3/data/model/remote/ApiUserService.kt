package com.mironenko.internship_task_3.data.model.remote

import com.mironenko.internship_task_3.util.AMOUNT_DOWNLOAD_PAGE
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUserService {

    @GET("api/")
    suspend fun downloadUser(
        @Query("results") results: Int = AMOUNT_DOWNLOAD_PAGE,
        @Query("seed") seed: String = "abc"
    ): UserListResponse
}