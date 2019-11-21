package com.ybleeho.timeline.di

import androidx.lifecycle.ViewModel
import com.ybleeho.timeline.ui.main.MainFragment
import com.ybleeho.timeline.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {
    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun mainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewmodel: MainViewModel): ViewModel
}