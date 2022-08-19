package com.mironenko.internship_task_3.ui.list

import com.mironenko.internship_task_3.base.BaseViewModel
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor

class UserListViewModel(
    interactors: Set<GetUsersInteractor>,
) : BaseViewModel<UserListState, UserListAction>(
    interactors = interactors,
    reducer = UserListReducer()
) {

    fun loadUsers() {
        action(UserListAction.LoadUsers)
    }
}