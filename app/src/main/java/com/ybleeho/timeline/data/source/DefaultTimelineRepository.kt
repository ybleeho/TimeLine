package com.ybleeho.timeline.data.source

import com.ybleeho.timeline.data.Result
import com.ybleeho.timeline.data.Timeline
import com.ybleeho.timeline.di.ApplicationModule.TimelineLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultTimelineRepository @Inject constructor(
    @TimelineLocalDataSource private val timelineLocalDataSource: TimelineDataSourse,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TimelineRepository {


    override suspend fun getTimeLine(): Result<List<Timeline>> {

        val localTimeline = timelineLocalDataSource.getTimeLine()
        return localTimeline
    }


    override suspend fun saveTimeLine(timeline: Timeline) {
        timelineLocalDataSource.saveTimeLine(timeline)
    }

}