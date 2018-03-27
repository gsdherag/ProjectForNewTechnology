package com.shouxiu.bear

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.Toast
import com.shouxiu.bear.fragment.HomeFragment
import com.shouxiu.bear.view.NavigateTabBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG_PAGE_HOME = "首页"
    private val TAG_PAGE_LIVE = "直播"
    private val TAG_PAGE_VIDEO = "视频"
    private val TAG_PAGE_FOLLOW = "关注"
    private val TAG_PAGE_USER = "我的"

    //    退出时间
    private var exitTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTabBar.onRestoreInstanceState(savedInstanceState)
        mainTabBar.addTab(HomeFragment::class.java, NavigateTabBar.TabParam(R.drawable.home_pressed, R.drawable.home_selected, TAG_PAGE_HOME))
        mainTabBar.addTab(HomeFragment::class.java, NavigateTabBar.TabParam(R.drawable.live_pressed, R.drawable.live_selected, TAG_PAGE_LIVE))
        mainTabBar.addTab(HomeFragment::class.java, NavigateTabBar.TabParam(R.drawable.video_pressed, R.drawable.video_selected, TAG_PAGE_VIDEO))
        mainTabBar.addTab(HomeFragment::class.java, NavigateTabBar.TabParam(R.drawable.follow_pressed, R.drawable.follow_selected, TAG_PAGE_FOLLOW))
        mainTabBar.addTab(HomeFragment::class.java, NavigateTabBar.TabParam(R.drawable.user_pressed, R.drawable.user_selected, TAG_PAGE_USER))
        mainTabBar.setTabSelectListener { holder ->
            when (holder.tag.toString()) {
                TAG_PAGE_HOME -> mainTabBar.showFragment(holder)
                TAG_PAGE_LIVE -> mainTabBar.showFragment(holder)
                TAG_PAGE_VIDEO -> mainTabBar.showFragment(holder)
                TAG_PAGE_FOLLOW -> mainTabBar.showFragment(holder)
                TAG_PAGE_USER -> if (mainTabBar != null) mainTabBar.showFragment(holder)
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exit() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(applicationContext, "再按一次退出程序",
                    Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            finish()
            System.exit(0)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        mainTabBar.onSaveInstanceState(outState)
    }
}
