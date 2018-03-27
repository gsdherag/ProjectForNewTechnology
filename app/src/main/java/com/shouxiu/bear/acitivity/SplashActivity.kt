package com.shouxiu.bear.acitivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.shouxiu.bear.MainActivity
import com.shouxiu.bear.R
import com.shouxiu.bear.utils.ConstantsImageUrl
import com.shouxiu.bear.view.PerfectClickListener
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : AppCompatActivity() {

    private val mHandler: Handler = object : Handler(Looper.getMainLooper()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        iv_pic.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.img_transition_default))
        val nextInt = Random().nextInt(ConstantsImageUrl.TRANSITION_URLS.size)
        Glide.with(this)
                .load(ConstantsImageUrl.TRANSITION_URLS[nextInt])
                .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)
                .into(iv_pic)

        mHandler.postDelayed({ iv_default_pic.visibility = View.GONE }, 1500)
        mHandler.postDelayed({ toMainActivity() }, 3500)
        tv_jump.setOnClickListener(object : PerfectClickListener() {
            override fun onNoDoubleClick(v: View?) {
                toMainActivity()
            }
        })
    }

    private fun toMainActivity() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacksAndMessages(null)
    }
}
