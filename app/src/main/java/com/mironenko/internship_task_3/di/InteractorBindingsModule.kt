package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoSet

@InstallIn(ViewModelComponent::class)
@Module
interface InteractorBindingsModule {

    @Binds
    @IntoSet
    fun bindGetUsersInterceptor(
        getUsersInteractor: GetUsersInteractor
    ): GetUsersInteractor

    @Binds
    @IntoSet
    fun bindGetUserByUdInterceptor(
        getUserByIdInteractor: GetUserByIdInteractor
    ): GetUserByIdInteractor
}