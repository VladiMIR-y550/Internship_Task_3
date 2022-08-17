package com.mironenko.internship_task_3.di

import android.content.Context
import com.mironenko.internship_task_3.ui.details.UserDetailsFragment
import com.mironenko.internship_task_3.ui.list.UserListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(fragment: UserListFragment)

    fun inject(fragment: UserDetailsFragment)
}