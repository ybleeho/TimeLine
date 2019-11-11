package com.ybleeho.timeline.base


import android.util.EventLog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.ybleeho.timeline.Event

internal abstract class BaseViewModel : ViewModel() {
    val navDirections = MutableLiveData<Event<NavDirections>>()
}