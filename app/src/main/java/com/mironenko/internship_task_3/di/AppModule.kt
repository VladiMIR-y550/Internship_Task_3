package com.mironenko.internship_task_3.di

import dagger.Module

@Module(
    includes = [
        DatabaseModule::class,
        NetworkModule::class,
        MapperBindingsModule::class,
        RepositoryBindingsModule::class,
        RepositoryModule::class
    ]
)
class AppModule