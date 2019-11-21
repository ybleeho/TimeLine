package com.ybleeho.timeline.ui.write

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ybleeho.timeline.data.source.TimelineRepository
import javax.inject.Inject

class WriteViewModel @Inject constructor(
    private val timelineRepository: TimelineRepository
):ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()



    fun saveTimeLine() {

    }

}