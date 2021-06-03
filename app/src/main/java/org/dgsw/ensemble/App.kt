package org.dgsw.ensemble

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.dgsw.ensemble.di.component.AppComponent

@HiltAndroidApp
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

    }

}