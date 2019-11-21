package com.ybleeho.timeline.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ybleeho.timeline.data.Timeline

@Database(entities = [Timeline::class], version = 1, exportSchema = false)
abstract class TimelineDatabase:RoomDatabase() {

    abstract fun timelineDao(): TimelineDao
}