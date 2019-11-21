package com.ybleeho.timeline.ui.main

import androidx.lifecycle.ViewModel
import com.ybleeho.timeline.Event
import com.ybleeho.timeline.base.BaseViewModel
import com.ybleeho.timeline.data.source.TimelineRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val timelineRepository: TimelineRepository
):ViewModel() {

}