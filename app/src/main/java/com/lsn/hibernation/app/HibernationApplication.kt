package com.lsn.hibernation.app

import android.app.Application
import com.lsn.hibernation.utils.comm.NetUtil

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/21
 * Description
 */
class HibernationApplication : Application() {

    companion object JVM {
        lateinit var get: HibernationApplication
    }

    private var pageSelectedPosition = 0

    override fun onCreate() {
        super.onCreate()
        get = this
        //DBManager.get.init(get)
    }


    fun isNetConnect(): Boolean {
        return NetUtil.isNetworkConnected(get)
    }


    fun setPageSelectedPosition(position: Int) {
        this.pageSelectedPosition = position
    }

    fun getPageSelectedPosition(): Int {
        return pageSelectedPosition
    }

}