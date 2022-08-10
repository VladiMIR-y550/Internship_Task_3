package com.mironenko.internship_task_3.data.interactors

import com.mironenko.internship_task_3.base.Interactor
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.mapper.UserMapper
import com.mironenko.internship_task_3.ui.list.UserListAction
import com.mironenko.internship_task_3.ui.list.UserListState

class GetUsersInteractor(private val repository: UsersRepository) :
    Interactor<UserListState, UserListAction> {

    override suspend fun invoke(state: UserListState, action: UserListAction): UserListAction {
        return if (action is UserListAction.LoadUsers) {
            val mapper = UserMapper()
            UserListAction.UsersLoaded(mapper.fromEntityList(repository.getUserList()))
        } else {
            UserListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: UserListAction): Boolean {
        return action is UserListAction.LoadUsers
    }

}