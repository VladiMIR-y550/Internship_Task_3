package com.mironenko.internship_task_3.ui.details

import com.mironenko.internship_task_3.base.Reducer

class UserDetailReducer(userId: String) : Reducer<UserDetailState, UserDetailAction> {
    override val initialState = UserDetailState(
        userId = userId,
        user = null
    )

    override fun reduce(state: UserDetailState, action: UserDetailAction): UserDetailState {
        return when (action) {
            UserDetailAction.None -> state
            UserDetailAction.LoadUser -> state
            is UserDetailAction.UserLoaded -> state.copy(
                user = action.user
            )
            is UserDetailAction.Error -> state
        }
    }
}