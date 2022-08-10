package com.mironenko.internship_task_3.data

import com.mironenko.internship_task_3.data.mapper.UserResponseMapper
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource

class UsersListRepository(
    private val remoteDataSource: UserListRemoteDataSource,
    private val localDataSource: UserListLocalDataSource
) : UsersRepository {

    override suspend fun getUserList(): List<UserDbEntity> {
        val mapper = UserResponseMapper()
        return try {
            val response = mapper.fromEntityList(remoteDataSource.downloadUserList().results)
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