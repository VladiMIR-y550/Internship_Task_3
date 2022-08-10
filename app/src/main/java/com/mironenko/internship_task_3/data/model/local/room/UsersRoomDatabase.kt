package com.mironenko.internship_task_3.data.model.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDbEntity::class], version = 1, exportSchema = true)
abstract class UsersRoomDatabase : RoomDatabase() {
    abstract fun getUsersListDao(): UsersDao
}