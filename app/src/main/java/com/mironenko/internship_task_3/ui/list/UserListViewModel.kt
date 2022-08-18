package com.mironenko.internship_task_3.ui.list

import com.mironenko.internship_task_3.base.BaseViewModel
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    interactors: Set<@JvmSuppressWildcards GetUsersInteractor>,
) : BaseViewModel<UserListState, UserListAction>(
    interactors = interactors,
    reducer = UserListReducer()
) {

    fun loadUsers() {
        action(UserListAction.LoadUsers)
    }
}