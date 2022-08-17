package com.mironenko.internship_task_3

import android.app.Application
import com.mironenko.internship_task_3.di.AppComponent
import com.mironenko.internship_task_3.di.DaggerAppComponent

class UserApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}