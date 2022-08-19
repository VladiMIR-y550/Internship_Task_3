package com.mironenko.internship_task_3.di

import androidx.room.Room
import com.mironenko.internship_task_3.data.model.local.room.UsersRoomDatabase
import com.mironenko.internship_task_3.util.USERS_ROOM_DATABASE
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            UsersRoomDatabase::class.java,
            USERS_ROOM_DATABASE
        ).build()
            .getUsersListDao()
    }
}