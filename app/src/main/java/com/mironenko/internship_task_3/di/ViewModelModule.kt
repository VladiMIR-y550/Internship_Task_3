package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.ui.details.UserDetailsViewModel
import com.mironenko.internship_task_3.ui.list.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        UserListViewModel(interactors = setOf(get()))
    }

    viewModel { state ->
        UserDetailsViewModel(
            interactors = setOf(get()), savedStateHandle = state.get()
        )
    }
}