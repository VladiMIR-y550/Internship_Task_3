package com.mironenko.internship_task_3.data

import com.mironenko.internship_task_3.data.mapper.UserResponseMapper
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource

class UsersListRepository(
    private val remoteDataSource: UserListRemoteDataSource,
    private val localDataSource: UserListLocalDataSource,
    private val mapper: UserResponseMapper
) : UsersRepository {

    private var isFirstStart: Boolean = true

    override suspend fun getUserList(): List<UserDbEntity> {

        return try {
            val response = mapper.fromEntityList(remoteDataSource.downloadUserList().results)
            if (isFirstStart) {
                localDataSource.clearAll()
                isFirstStart = false
            }
            localDataSource.saveUserList(response)
            response
        } catch (e: Exception) {
            localDataSource.getAllUsers()
        }
    }

    override suspend fun getUserById(userId: String): UserDbEntity {
        return localDataSource.getUserDbEntityById(userId)
    }
}