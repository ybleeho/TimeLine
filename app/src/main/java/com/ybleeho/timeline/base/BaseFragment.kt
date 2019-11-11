package com.ybleeho.timeline.base


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ybleeho.timeline.R

/**
 * A simple [Fragment] subclass.
 */
internal abstract class BaseFragment : Fragment() {

    protected open val navController: NavController
        get() = activity!!.findNavController(R.id.nav_gragh)


}
