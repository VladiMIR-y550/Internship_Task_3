package com.mironenko.internship_task_3.ui.details

import androidx.lifecycle.SavedStateHandle
import com.mironenko.internship_task_3.base.BaseViewModel
import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.util.ARG_USER_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    interactors: Set<GetUserByIdInteractor>,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<UserDetailState, UserDetailAction>(
    interactors = interactors,
    reducer = UserDetailReducer(savedStateHandle.get<String>(ARG_USER_ID)!!)
) {

    fun getUser() {
        action(UserDetailAction.LoadUser)
    }
}