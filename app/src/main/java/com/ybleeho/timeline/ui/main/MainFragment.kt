package com.ybleeho.timeline.ui.main


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ybleeho.timeline.R
import com.ybleeho.timeline.databinding.FragmentMainBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject


internal class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel>{ viewModelFactory }

    private lateinit var viewDataBinding: FragmentMainBinding

    private lateinit var listAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root =  inflater.inflate(R.layout.fragment_main, container, false)

        viewDataBinding = FragmentMainBinding.bind(root).apply {
            viewmodel = viewModel
        }
        setHasOptionsMenu(true)
        return viewDataBinding.root
        // Inflate the layout for this fragment
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpAddFab()
        setUpListAdapter()
        viewModel.loadTimeline()
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

    private fun setUpListAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if(viewModel != null) {
            listAdapter = MainAdapter(viewModel)
            viewDataBinding.timelineList.adapter = listAdapter
        }else {

        }
    }

}
