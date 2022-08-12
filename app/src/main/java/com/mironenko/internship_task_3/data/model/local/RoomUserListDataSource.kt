package com.mironenko.internship_task_3.data.model.local

import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.local.room.UsersDao

class RoomUserListDataSource(private val usersDao: UsersDao) : UserListLocalDataSource {
    override suspend fun getAllUsers(): List<UserDbEntity> {
        return usersDao.getAllUsers()
    }

    override suspend fun getUserDbEntityById(userId: String): UserDbEntity {
        return usersDao.getUserDbEntityById(userId)
    }

    override suspend fun saveUserList(userDbEntityList: List<UserDbEntity>) {
        usersDao.insertAll(userDbEntityList)
    }

    override suspend fun clearAll() {
        usersDao.clearAll()
    }
}