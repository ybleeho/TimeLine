package com.ybleeho.timeline.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ybleeho.timeline.Event
import com.ybleeho.timeline.base.BaseViewModel
import com.ybleeho.timeline.data.Result
import com.ybleeho.timeline.data.Timeline
import com.ybleeho.timeline.data.source.TimelineRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val timelineRepository: TimelineRepository
):ViewModel() {

//    val arr = List(20) { Timeline() }

    private val _items = MutableLiveData<List<Timeline>>().apply { value = emptyList() }
    val items: LiveData<List<Timeline>> = _items


    fun loadTimeline() {
        getTimeline()
    }

    private fun getTimeline() = viewModelScope.launch {
        val timelineResult  = timelineRepository.getTimeLine()
        if(timelineResult is Result.Success){
            val timelines = timelineResult.data
            _items.value = timelines
        }
    }

}