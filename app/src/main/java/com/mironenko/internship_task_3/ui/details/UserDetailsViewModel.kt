package com.mironenko.internship_task_3.ui.details

import com.mironenko.internship_task_3.base.BaseViewModel
import com.mironenko.internship_task_3.base.Interactor

class UserDetailsViewModel(
    interactors: Set<Interactor<UserDetailState, UserDetailAction>>,
    userId: String
) :
    BaseViewModel<UserDetailState, UserDetailAction>(
        interactors = interactors,
        reducer = UserDetailReducer(userId)
    ) {

    fun getUser() {
        action(UserDetailAction.LoadUser)
    }
}