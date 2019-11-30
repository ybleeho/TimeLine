package com.ybleeho.timeline.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ybleeho.timeline.data.Timeline

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Timeline>) {
    (listView.adapter as MainAdapter).submitList(items)
}