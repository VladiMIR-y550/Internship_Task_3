package com.mironenko.internship_task_3.data.model.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {
    @Query("SELECT * FROM USERS_TABLE")
    suspend fun getAllUsers(): List<UserDbEntity>

    @Query("SELECT * FROM USERS_TABLE WHERE id = :userId")
    suspend fun getUserDbEntityById(userId: String): UserDbEntity

    @Insert(entity = UserDbEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(userDbEntityList: List<UserDbEntity>)
}