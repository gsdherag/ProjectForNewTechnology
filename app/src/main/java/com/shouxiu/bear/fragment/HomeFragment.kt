package com.shouxiu.bear.fragment

import com.shouxiu.bear.R
import com.shouxiu.bear.base.BaseFragment

/**
 * @author     yeping
 * @date   2018/3/27 15:34
 * 首页fragment
 */
class HomeFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_home_one
    }

    override fun init() {
//        viewpager.offscreenPageLimit =
    }

    override fun lazyFetchData() {

    }
}