package com.ybleeho.timeline.di

import android.content.Context
import com.ybleeho.timeline.TimeLineApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        MainModule::class,
        WriteModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<TimeLineApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}