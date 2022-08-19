package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import org.koin.dsl.module

val interactorsModule = module {

    factory {
        GetUsersInteractor(repository = get())
    }

    factory {
        GetUserByIdInteractor(repository = get())
    }
}