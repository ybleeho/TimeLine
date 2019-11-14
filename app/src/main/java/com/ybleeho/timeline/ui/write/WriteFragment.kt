package com.ybleeho.timeline.ui.write


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresPermission
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.ybleeho.timeline.R
import com.ybleeho.timeline.base.BaseFragment
import com.ybleeho.timeline.ui.main.MainFragmentDirections
import kotlinx.android.synthetic.main.toolbar.*

/**
 * A simple [Fragment] subclass.
 */
internal class WriteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_write, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        setUpSaveFab()
        super.onActivityCreated(savedInstanceState)
    }




    private fun setUpSaveFab() {
        activity?.findViewById<FloatingActionButton>(R.id.save_timeline_fab)?.let{
            it.setOnClickListener {
                setupNavigation()
            }
        }
    }

    private fun setupNavigation() {
        var action = WriteFragmentDirections.actionWriteFragmentDestToMainFragmentDest()
        findNavController().navigate(action)
    }

}
