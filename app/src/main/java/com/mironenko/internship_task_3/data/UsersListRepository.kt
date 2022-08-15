package com.mironenko.internship_task_3.data

import com.mironenko.internship_task_3.data.mapper.UserResponseMapper
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource

class UsersListRepository private constructor(
    private var remoteDataSource: UserListRemoteDataSource,
    private var localDataSource: UserListLocalDataSource,
    private var mapper: UserResponseMapper
) : UsersRepository {

    companion object {
        private var instance: UsersListRepository? = null

        fun getInstance(
            remoteDataSource: UserListRemoteDataSource,
            localDataSource: UserListLocalDataSource,
            mapper: UserResponseMapper
        ): UsersListRepository? {
            if (instance == null) {
                synchronized(UsersListRepository::class.java) {
                    if (instance == null) {
                        instance = UsersListRepository(
                            remoteDataSource = remoteDataSource,
                            localDataSource = localDataSource,
                            mapper = mapper
                        )
                    }
                }
            }
            return instance
        }
    }

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