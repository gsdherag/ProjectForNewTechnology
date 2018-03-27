package com.shouxiu.bear.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shouxiu.bear.R

/**
 * @author     yeping
 * @date   2018/3/27 15:34
 * TODO
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home_one, container, false)
        return view
    }


}