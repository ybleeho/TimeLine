package com.ybleeho.timeline.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ybleeho.timeline.data.Timeline

@Dao
interface TimelineDao {
    @Query("SELECT * FROM Timeline")
    suspend fun getTimeline(): List<Timeline>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimeline(timeline: Timeline)
}