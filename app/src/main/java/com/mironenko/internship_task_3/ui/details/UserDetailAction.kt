package com.mironenko.internship_task_3.ui.details

import com.mironenko.internship_task_3.data.User

sealed class UserDetailAction {
    object None : UserDetailAction()
    object LoadUser : UserDetailAction()
    data class UserLoaded(val user: User) : UserDetailAction()
    data class Error(val error: Exception) : UserDetailAction()
}