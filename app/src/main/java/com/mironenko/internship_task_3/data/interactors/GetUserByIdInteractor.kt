package com.mironenko.internship_task_3.data.interactors

import com.mironenko.internship_task_3.base.Interactor
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.mapper.UserMapper
import com.mironenko.internship_task_3.ui.details.UserDetailAction
import com.mironenko.internship_task_3.ui.details.UserDetailState

class GetUserByIdInteractor(
    private val repository: UsersRepository,
    private val mapper: UserMapper
) :
    Interactor<UserDetailState, UserDetailAction> {
    override suspend fun invoke(
        state: UserDetailState,
        action: UserDetailAction
    ): UserDetailAction {
        return if (action is UserDetailAction.LoadUser) {
            try {
                val user = mapper.mapFromEntity(repository.getUserById(state.userId))
                UserDetailAction.UserLoaded(user = user)
            } catch (e: Exception) {
                UserDetailAction.Error(e)
            }
        } else {
            UserDetailAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: UserDetailAction): Boolean {
        return action is UserDetailAction.LoadUser
    }

}