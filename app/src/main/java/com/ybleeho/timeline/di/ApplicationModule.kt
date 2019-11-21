package com.ybleeho.timeline.di

import android.content.Context
import androidx.room.Room
import com.ybleeho.timeline.data.source.DefaultTimelineRepository
import com.ybleeho.timeline.data.source.TimelineDataSourse
import com.ybleeho.timeline.data.source.TimelineRepository
import com.ybleeho.timeline.data.source.local.TimelineDatabase
import com.ybleeho.timeline.data.source.local.TimelineLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME


@Module(includes = [])
object ApplicationModule {

    @Qualifier
    @Retention(RUNTIME)
    annotation class TimelineLocalDataSource

    @JvmStatic
    @Singleton
    @TimelineLocalDataSource
    @Provides
    fun provideTimelineLocalDataSource(
        database: TimelineDatabase,
        ioDispatcher: CoroutineDispatcher
    ): TimelineDataSourse {
       return TimelineLocalDataSource(
          database.timelineDao(), ioDispatcher
       )
    }


    @JvmStatic
    @Singleton
    @Provides
    fun provideTimelineDatabase(context: Context): TimelineDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TimelineDatabase::class.java,
            "Timeline.db"
        ).build()
    }


    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO


}



//@Module
//abstract class ApplicationModuleBind {
//    @Singleton
//    @Binds
//    abstract fun bindRepository(repo: DefaultTimelineRepository): TimelineRepository
//}