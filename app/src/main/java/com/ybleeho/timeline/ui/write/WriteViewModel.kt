package com.ybleeho.timeline.ui.write

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ybleeho.timeline.Event
import com.ybleeho.timeline.data.Timeline
import com.ybleeho.timeline.data.source.TimelineRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class WriteViewModel @Inject constructor(
    private val timelineRepository: TimelineRepository
):ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    private val _timelineCreated = MutableLiveData<Event<Unit>>()
    val timelineCreatedEvent: LiveData<Event<Unit>> = _timelineCreated



    fun saveTimeLine() {
        val currentTitle = title.value
        val currentDescription = description.value

        println("currentTitle:"+currentTitle+currentDescription)
        if (currentTitle == null || currentDescription == null) {
            return
        }
        createTimeline(Timeline(currentTitle, currentDescription))
    }


    fun test() {
        println("setup---------------------")
    }

    private fun createTimeline(newTimeline: Timeline) = viewModelScope.launch {
        println("create timeline-------------")
        timelineRepository.saveTimeLine(newTimeline)
        _timelineCreated.value = Event(Unit)
    }

}