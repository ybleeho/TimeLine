package com.ybleeho.timeline.ui.write


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.ybleeho.timeline.R
import com.ybleeho.timeline.base.BaseFragment
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
        super.onActivityCreated(savedInstanceState)

        toolbar.run {
            setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
            inflateMenu(R.menu.menu_save)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_write -> {
                        view?.findNavController()
                            ?.navigate(R.id.main_fragment_dest)
                    }
                }
                false
            }
            setNavigationOnClickListener { navController.popBackStack() }
        }
    }


}
