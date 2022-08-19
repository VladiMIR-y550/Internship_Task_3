package com.mironenko.internship_task_3.di

import com.mironenko.internship_task_3.util.DateFormatter
import com.mironenko.internship_task_3.util.UserDateFormatter
import org.koin.dsl.module

val dateFormatterModule = module {

    single<DateFormatter> {
        UserDateFormatter()
    }
}