package com.mironenko.internship_task_3

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.mironenko.internship_task_3.data.model.local.room.UsersRoomDatabase
import com.mironenko.internship_task_3.data.model.remote.ApiUserService
import com.mironenko.internship_task_3.util.USERS_ROOM_DATABASE
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//val Context.apiUserService: ApiUserService
//    get() = when (this) {
//        is UserApp -> apiUserService
//        else -> this.applicationContext.apiUserService
//    }
//
//val Context.usersRoomDataBase: UsersRoomDatabase
//    get() = when (this) {
//        is UserApp -> roomDataBase
//        else -> this.applicationContext.usersRoomDataBase
//    }

@HiltAndroidApp
class UserApp : Application() {

//    val apiUserService: ApiUserService by lazy { initRetrofitClient() }
//    val roomDataBase: UsersRoomDatabase by lazy { initDataBase() }

//    private fun initRetrofitClient(): ApiUserService {
//        val baseUrl = "https://randomuser.me/"
//
//        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
//            this.level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        val okhttpClient: OkHttpClient = OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()
//
//        val gsonConvertedFactory = GsonConverterFactory.create()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(okhttpClient)
//            .addConverterFactory(gsonConvertedFactory)
//            .build()
//
//        return retrofit.create(ApiUserService::class.java)
//    }

//    private fun initDataBase(): UsersRoomDatabase {
//        return Room.databaseBuilder(
//            applicationContext,
//            UsersRoomDatabase::class.java,
//            USERS_ROOM_DATABASE
//        ).build()
//    }
}