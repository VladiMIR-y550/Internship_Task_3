package com.mironenko.internship_task_3.util.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mironenko.internship_task_3.data.UsersRepository
import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.ui.details.UserDetailsViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class UserDetailsViewModelFactory @AssistedInject constructor(
    private val repository: UsersRepository,
    @Assisted("userId") private val userId: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailsViewModel(
            setOf(GetUserByIdInteractor(repository = repository)),
            userId = userId
        ) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("userId") userId: String): UserDetailsViewModelFactory
    }
}