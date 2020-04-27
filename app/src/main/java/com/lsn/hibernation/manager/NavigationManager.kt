package com.lsn.hibernation.manager

import android.app.Activity
import com.lsn.hibernation.R
import com.lsn.hibernation.ui.widget.EasyNavigation

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/27 15:33
 * Description
 */
class NavigationManager private constructor() {

    companion object JVM {
        val get = NavigationManager()
    }

    /**
     *  常规的 NavigationBar
     */
    fun initCommonBar(activity : Activity, title:String){
        getCommonBar(activity,title)
            .build()
    }

    fun initPlaylistBar(activity: Activity){
        getImmersionBar(activity, "").build()
    }

    private fun getImmersionBar(activity : Activity, title:String) : EasyNavigation.Builder =
        EasyNavigation.Builder(activity)
            .setNavigationMode(EasyNavigation.NavigationMode.SIMPLE_IMMERSION)
            .setTitle(title)
            .setBackIcon(R.drawable.svg_back)
            .setBackground(android.R.color.transparent)


    private fun getCommonBar(activity : Activity, title:String) : EasyNavigation.Builder =
        EasyNavigation.Builder(activity)
            .setNavigationMode(EasyNavigation.NavigationMode.SEPARATE)
            .setTitle(title)
            .setStatusBarColor(R.color.colorAccent)
            .setBackIcon(R.mipmap.ic_back)
            .setBackground(android.R.color.white)

}