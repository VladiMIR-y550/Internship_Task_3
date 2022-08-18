package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.base.Interactor
import com.mironenko.internship_task_3.base.UserAction
import com.mironenko.internship_task_3.base.UserState
import com.mironenko.internship_task_3.data.interactors.GetUserByIdInteractor
import com.mironenko.internship_task_3.data.interactors.GetUsersInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds

@InstallIn(ViewModelComponent::class)
@Module
interface InteractorBindingsModule {

    @Multibinds
    fun interactors(): Set<@JvmSuppressWildcards Interactor<UserState, UserAction>>

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