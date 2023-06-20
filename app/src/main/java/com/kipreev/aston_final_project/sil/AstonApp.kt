package com.kipreev.aston_final_project

import android.app.Application
import com.kipreev.aston_final_project.di.AppComponent
import com.kipreev.aston_final_project.di.DaggerAppComponent
import com.kipreev.aston_final_project.sil.di.ContextModule

class AstonApp : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().contextModule(ContextModule(this.applicationContext)).build()
    }

}