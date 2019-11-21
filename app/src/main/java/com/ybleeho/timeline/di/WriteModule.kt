package com.ybleeho.timeline.di

import androidx.lifecycle.ViewModel
import com.ybleeho.timeline.ui.main.MainViewModel
import com.ybleeho.timeline.ui.write.WriteFragment
import com.ybleeho.timeline.ui.write.WriteViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class WriteModule {
    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun writeFragment(): WriteFragment

    @Binds
    @IntoMap
    @ViewModelKey(WriteViewModel::class)
    abstract fun bindViewModel(viewmodel: WriteViewModel): ViewModel
}