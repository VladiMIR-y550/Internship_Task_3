package com.mironenko.internship_task_3.data

import com.mironenko.internship_task_3.data.mapper.EntityMapper
import com.mironenko.internship_task_3.data.model.local.UserListLocalDataSource
import com.mironenko.internship_task_3.data.model.local.room.UserDbEntity
import com.mironenko.internship_task_3.data.model.remote.UserListRemoteDataSource
import com.mironenko.internship_task_3.data.model.remote.UserResponse

class UsersListRepository private constructor(
    private var remoteDataSource: UserListRemoteDataSource,
    private var localDataSource: UserListLocalDataSource,
    private var mapper: EntityMapper<UserResponse, UserDbEntity, User>
) : UsersRepository {

    private var isFirstStart: Boolean = true

    override suspend fun getUserList(): List<User> {

        return try {
            val response =
                mapper.fromResponseEntityList(remoteDataSource.downloadUserList().results)
            if (isFirstStart) {
                localDataSource.clearAll()
                isFirstStart = false
            }
            localDataSource.saveUserList(response)
            mapper.fromDbEntityList(response)
        } catch (e: Exception) {
            mapper.fromDbEntityList(localDataSource.getAllUsers())
        }
    }

    override suspend fun getUserById(userId: String): User {
        return mapper.dbEntityToUser(localDataSource.getUserDbEntityById(userId))
    }

    companion object {
        private var instance: UsersListRepository? = null

        fun getInstance(
            remoteDataSource: UserListRemoteDataSource,
            localDataSource: UserListLocalDataSource,
            mapper: EntityMapper<UserResponse, UserDbEntity, User>
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
}