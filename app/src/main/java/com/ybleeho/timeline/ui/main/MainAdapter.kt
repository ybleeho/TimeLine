package com.ybleeho.timeline.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ybleeho.timeline.data.Timeline
import com.ybleeho.timeline.databinding.MainItemBinding

class MainAdapter(private val viewModel: MainViewModel) :
    ListAdapter<Timeline, MainAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(viewModel, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: MainViewModel, item: Timeline) {

            binding.viewmodel = viewModel
            binding.timeline = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MainItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}


class TaskDiffCallback : DiffUtil.ItemCallback<Timeline>() {
    override fun areItemsTheSame(oldItem: Timeline, newItem: Timeline): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Timeline, newItem: Timeline): Boolean {
        return oldItem == newItem
    }
}
