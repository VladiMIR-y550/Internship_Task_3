package com.mironenko.internship_task_3.ui.details

import com.mironenko.internship_task_3.base.UserState
import com.mironenko.internship_task_3.data.User
import javax.inject.Inject

data class UserDetailState @Inject constructor(
    val userId: String,
    val user: User?
) : UserState