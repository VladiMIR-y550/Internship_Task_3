package com.mironenko.internship_task_3.ui.list

import com.mironenko.internship_task_3.base.UserState
import com.mironenko.internship_task_3.data.User

data class UserListState(
    val usersList: List<User>
) : UserState