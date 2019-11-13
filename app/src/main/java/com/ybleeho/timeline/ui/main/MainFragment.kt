package com.ybleeho.timeline.ui.main


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

import com.ybleeho.timeline.R
import com.ybleeho.timeline.base.BaseFragment
import kotlinx.android.synthetic.main.toolbar.*


internal class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpAddFab()
    }


    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_write -> {
                Toast.makeText(context, "Love", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_write, menu)
    }


    private fun setUpAddFab() {
        activity?.findViewById<FloatingActionButton>(R.id.add_fab)?.let{
            it.setOnClickListener {
//                Toast.makeText(context, "FloatingActionButton", Toast.LENGTH_SHORT).show()
                navigateToWrite()
            }
        }
    }

    private fun navigateToWrite() {
        var action = MainFragmentDirections.actionMainFragmentToWriteFragment()
        findNavController().navigate(action)
    }

}
