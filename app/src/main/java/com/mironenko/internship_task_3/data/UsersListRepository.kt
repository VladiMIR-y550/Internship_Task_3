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
        val listUser = mutableListOf<UserDbEntity>()

        val response = remoteDataSource.downloadUserList()

        return if (response.isSuccessful) {
            response.body()?.results?.forEach {
                val userDbEntity = mapper.mapFromEntity(it)
                localDataSource.saveUserToDataBase(userDbEntity)
                listUser.add(userDbEntity)
            }
            listUser
        } else {
            localDataSource.getAllUsers()
        }
    }

    override suspend fun getUserById(userId: String): UserDbEntity {
        return localDataSource.getUserDbEntityById(userId)
    }
}