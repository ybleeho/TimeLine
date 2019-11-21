package com.ybleeho.timeline.data.source

import com.ybleeho.timeline.data.Result
import com.ybleeho.timeline.data.Timeline


interface TimelineRepository {
    suspend fun getTimeLine(): Result<List<Timeline>>

    suspend fun saveTimeLine(timeline: Timeline)
}