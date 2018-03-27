package com.shouxiu.bear

import android.app.Application
import android.content.Context
import com.squareup.leakcanary.LeakCanary

/**
 * @author     yeping
 * @date   2018/3/27 14:28
 * TODO
 */
class MyApp : Application() {

    private lateinit var instance: MyApp
    override fun onCreate() {
        super.onCreate()
        instance = this
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    /**
     * @return
     * @Description 得到实例
     */
    fun getInstance(): MyApp {
        return instance
    }

    /**
     * @return
     * @Description 得到实例
     */
    fun getContext(): Context {
        return getInstance().applicationContext
    }
}