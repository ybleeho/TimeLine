package com.ybleeho.timeline.data.source.local

import com.ybleeho.timeline.data.Result
import com.ybleeho.timeline.data.Timeline
import com.ybleeho.timeline.data.source.TimelineDataSourse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class TimelineLocalDataSource internal constructor(
    private val timelineDao: TimelineDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TimelineDataSourse {

    override suspend fun getTimeLine(): Result<List<Timeline>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(timelineDao.getTimeline())
        } catch (e: Exception) {
            Result.Error(e)
        }

    }
    override suspend fun saveTimeLine(timeline: Timeline) = withContext(ioDispatcher){
        timelineDao.insertTimeline(timeline)
    }
}