package org.dgsw.ensemble.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import org.dgsw.ensemble.App
import org.dgsw.ensemble.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    // app
    fun inject(app: App)

}