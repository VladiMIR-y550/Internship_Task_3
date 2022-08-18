package com.mironenko.internship_task_3.ui.list

import com.mironenko.internship_task_3.base.UserAction
import com.mironenko.internship_task_3.data.User

sealed class UserListAction : UserAction {
    object None : UserListAction()
    object LoadUsers : UserListAction()
    data class UsersLoaded(val users: List<User>) : UserListAction()
    data class Error(val error: Exception) : UserListAction()
}