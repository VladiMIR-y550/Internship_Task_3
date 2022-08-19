package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.model.remote.ApiUserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<ApiUserService> {
        val baseUrl = "https://randomuser.me/"

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val okhttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val gsonConvertedFactory = GsonConverterFactory.create()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttpClient)
            .addConverterFactory(gsonConvertedFactory)
            .build()

        retrofit.create(ApiUserService::class.java)
    }
}