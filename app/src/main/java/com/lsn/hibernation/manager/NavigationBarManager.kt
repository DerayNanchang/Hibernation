package com.lsn.hibernation.manager

import android.app.Activity
import com.lsn.hibernation.R
import com.lsn.hibernation.ui.widget.EasyNavigation

/**
 * Author: Chris
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2019/1/11
 * Description
 */
class NavigationBarManager private constructor(){

    companion object JVM{
        val get = NavigationBarManager()
    }



    /**
     *  常规的 NavigationBar
     */
    fun initCommonBar(activity : Activity, title:String){
                getCommonBar(activity,title)
                .build()
    }







    private fun getCommonBar(activity : Activity, title:String) : EasyNavigation.Builder =
            EasyNavigation.Builder(activity)
                    .setNavigationMode(EasyNavigation.NavigationMode.SEPARATE)
                    .setTitle(title)
                    .setStatusBarColor(R.color.colorAccent)
                    .setBackIcon(R.mipmap.ic_back)
                    .setBackground(android.R.color.white)
}