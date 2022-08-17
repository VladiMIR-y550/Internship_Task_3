package com.mironenko.internship_task_3.di

import android.content.Context
import androidx.room.Room
import com.mironenko.internship_task_3.data.model.local.room.UsersRoomDatabase
import com.mironenko.internship_task_3.util.USERS_ROOM_DATABASE
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(applicationContext: Context): UsersRoomDatabase {
        return Room.databaseBuilder(
            applicationContext,
            UsersRoomDatabase::class.java,
            USERS_ROOM_DATABASE
        ).build()
    }
}