package com.mironenko.internship_task_3.ui.details

import com.mironenko.internship_task_3.data.User

data class UserDetailState(
    val userId: String,
    val user: User?
)