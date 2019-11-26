package com.ybleeho.timeline.ui.write


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresPermission
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ybleeho.timeline.EventObserver

import com.ybleeho.timeline.R
import com.ybleeho.timeline.base.BaseFragment
import com.ybleeho.timeline.databinding.FragmentWriteBinding
import com.ybleeho.timeline.ui.main.MainFragmentDirections
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WriteFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<WriteViewModel> { viewModelFactory }

    private lateinit var viewDataBinding: FragmentWriteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root =  inflater.inflate(R.layout.fragment_write, container, false)

        viewDataBinding = FragmentWriteBinding.bind(root).apply {
            viewmodel = viewModel
        }
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.test()

        return viewDataBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        setupNavigation()
        super.onActivityCreated(savedInstanceState)
    }




//    private fun setUpSaveFab() {
//        activity?.findViewById<FloatingActionButton>(R.id.save_timeline_fab)?.let{
//            it.setOnClickListener {
//                setupNavigation()
//            }
//        }
//    }

    private fun setupNavigation() {


        viewModel.timelineCreatedEvent.observe(this, EventObserver {
            viewModel.test()
            var action = WriteFragmentDirections.actionWriteFragmentDestToMainFragmentDest()
            findNavController().navigate(action)
        })
    }

}
