package com.mironenko.internship_task_3

import android.app.Application
import com.mironenko.internship_task_3.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UserApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@UserApp)
            modules(
                listOf(
                    databaseModule,
                    dateFormatterModule,
                    mapperModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    interactorsModule,
                    repositoryModule
                )
            )
        }
    }
}