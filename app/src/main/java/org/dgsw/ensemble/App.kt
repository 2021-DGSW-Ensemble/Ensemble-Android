package org.dgsw.ensemble

import android.app.Application
import org.dgsw.ensemble.di.component.AppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        //app = this
        //appComponent = DaggerAppComponent.builder()

    }

}