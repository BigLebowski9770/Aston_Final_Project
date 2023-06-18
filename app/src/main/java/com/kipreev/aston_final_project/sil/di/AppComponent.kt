package com.kipreev.aston_final_project.di

import com.kipreev.aston_final_project.data.network.di.DataModule
import com.kipreev.aston_final_project.domain.di.DomainModule
import com.kipreev.aston_final_project.presentation.activities.MainActivity
import com.kipreev.aston_final_project.presentation.di.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class, PresentationModule::class])
interface AppComponent {

    fun injectMainAcivity(mainActivity: MainActivity)

}