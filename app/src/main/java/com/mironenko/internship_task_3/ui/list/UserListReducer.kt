package com.mironenko.internship_task_3.ui.list

import com.mironenko.internship_task_3.base.Reducer

class UserListReducer : Reducer<UserListState, UserListAction> {
    override val initialState = UserListState(
        usersList = listOf()
    )

    override fun reduce(state: UserListState, action: UserListAction): UserListState {
        return when(action) {
            UserListAction.None -> state
            UserListAction.LoadUsers -> state
            is UserListAction.UsersLoaded -> state.copy(
                usersList = action.users
            )
            is UserListAction.Error -> state        //если пришёл action.error мы должны загрузить из БД
        }
    }
}