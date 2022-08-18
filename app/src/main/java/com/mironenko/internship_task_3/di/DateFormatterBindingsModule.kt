package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.util.DateFormatter
import com.mironenko.internship_task_3.util.UserDateFormatter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DateFormatterBindingsModule {

    @Binds
    fun bindDateFormatter(userDateFormatter: UserDateFormatter): DateFormatter
}